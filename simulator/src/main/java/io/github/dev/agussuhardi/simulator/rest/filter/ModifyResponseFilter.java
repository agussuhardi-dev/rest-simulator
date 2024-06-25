package io.github.dev.agussuhardi.simulator.rest.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.dev.agussuhardi.simulator.rest.entity.HttpHistory;
import io.github.dev.agussuhardi.simulator.rest.repository.HttpHistoryRepository;
import io.github.dev.agussuhardi.simulator.rest.repository.HttpRepository;
import io.github.dev.agussuhardi.simulator.rest.util.ObjectMapperUtil;
import io.micrometer.common.lang.NonNullApi;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.github.dev.agussuhardi.simulator.rest.util.ObjectMapperUtil.getJsonNode;

/**
 * @author agussuhardi
 * {@code @created} 6/21/24 8:33 PM
 * {@code @project} simulator
 */
@Component
@RequiredArgsConstructor
@Slf4j
@NonNullApi
public class ModifyResponseFilter implements WebFilter {

    private final HttpRepository httpRepository;
    private final HttpHistoryRepository httpHistoryRepository;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("Request Path: {}", request.getPath());

        return DataBufferUtils.join(request.getBody())
                .flatMap(dataBuffer -> {
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);


                    var history = new HttpHistory();
                    history.setRequestPathUrl(request.getPath().toString());
                    history.setRequestMethod(request.getMethod().name());
                    history.setRequestQueryParamJSONB(ObjectMapperUtil.toJson(request.getQueryParams()));
                    history.setRequestHeaderJSONB(ObjectMapperUtil.toJson(request.getHeaders()));
                    history.setRequestBodyJSONB(body);
                    history.setCreatedAt(System.currentTimeMillis());
                    httpHistoryRepository.save(history).subscribe();


                    var httpPathUrl = request.getPath().toString();
                    var httpMethod = request.getMethod().name();
                    MultiValueMap<String, String> httpQueryParams = request.getQueryParams();
                    MultiValueMap<String, String> httpHeaders = request.getHeaders();
                    JsonNode httpBody = getJsonNode(body);

                    System.out.println("========================");
                    log.warn("path=>{}", httpPathUrl);
                    log.warn("method=>{}", httpMethod);
                    log.warn("query params=>{}", httpQueryParams);
                    log.warn("headers=>{}", httpHeaders);
                    log.warn("body=>{}", body);
                    System.out.println("========================");


                    var queryParams = httpRepository.findByRequestMethodAndRequestPathUrl(httpMethod, httpPathUrl)
                            .collect(Collectors.toList())
                            .flatMapIterable(list -> list.stream().filter(entity -> {
                                        log.info("<<FILTER QUERY PARAMS>>");
                                        var queryParamEntity = getQueryParams(entity.getRequestQueryParamJSONB());
                                        if (queryParamEntity.isEmpty()) {
                                            return true;
                                        }
                                        return !queryParamEntity.keySet()
                                                .stream()
                                                .filter(httpQueryParams::containsKey)
                                                .collect(Collectors.toMap(Function.identity(), httpQueryParams::get))
                                                .isEmpty();
                                    })
                                    .toList());

                    var headers = queryParams
                            .filter(entity -> {
                                log.info("<<FILTER HEADERS>>");
                                var httpHeadersEntity = getQueryParams(entity.getRequestHeaderJSONB());
                                if (httpHeadersEntity.isEmpty()) {
                                    return true;
                                }
                                return !httpHeadersEntity
                                        .entrySet().stream().filter(key -> httpHeaders.containsKey(key.getKey()))
                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).isEmpty();
                            });

                    var bodyFilter = headers.filter(entity -> {
                        log.info("<<FILTER QUERY BODY>>");
                        var bodyEntity = getJsonNode(entity.getRequestBodyJSONB());
                        if (bodyEntity.isEmpty()) {
                            return true;
                        }
                        return bodyEntity.equals(httpBody);
                    });

                    var modifyResponse = bodyFilter.flatMap(responseEntity -> {
                        log.info("<<CREATE RESPONSE BODY>>");
                        if (responseEntity.getResponseTimeInMillis() != null) {
                            try {
                                TimeUnit.MILLISECONDS.sleep(responseEntity.getResponseTimeInMillis());
                            } catch (InterruptedException ie) {
                                log.error("InterruptedException: ", ie);
                                Thread.currentThread().interrupt();
                            }
                        }
                        log.info("Response ID: {}", responseEntity.getId());


//                        response.getHeaders().set("Content-Type",MediaType.APPLICATION_JSON_VALUE););

                        var response = exchange.getResponse();
                        response.beforeCommit(() -> {
                            response.setStatusCode(HttpStatus.valueOf(responseEntity.getResponseHttpStatusCode()));
                            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                            return Mono.empty();
                        });
                        return response.writeWith(Mono.fromSupplier(() -> {
                            return response.bufferFactory().wrap(responseEntity.getResponseBody().getBytes(StandardCharsets.UTF_8));
                        }));
                    });
                    return modifyResponse.then();
                });


    }

    @SneakyThrows
    private Map<String, String[]> getQueryParams(String json) {
        return ObjectMapperUtil.getInstance().readValue(json, new TypeReference<>() {
        });
    }


}
