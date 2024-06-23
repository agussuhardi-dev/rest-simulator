package io.github.dev.agussuhardi.simulator.rest.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.dev.agussuhardi.simulator.rest.RestApplication;
import io.github.dev.agussuhardi.simulator.rest.repository.HttpRequestRepository;
import io.github.dev.agussuhardi.simulator.rest.repository.HttpResponseRepository;
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

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    private final HttpRequestRepository httpRequestRepository;
    private final RestApplication restApplication;
    private final HttpResponseRepository httpResponseRepository;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("Request Path: {}", request.getPath());

        return DataBufferUtils.join(request.getBody())
                .flatMap(dataBuffer -> {
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);

                    var httpPathUrl = request.getPath().toString();
                    var httpMethod = request.getMethod().name();
                    MultiValueMap<String, String> httpQueryParams = request.getQueryParams();
                    MultiValueMap<String, String> httpHeaders = request.getHeaders();
                    JsonNode httpBody = ObjectMapperUtil.getJsonNode(body);


                    System.out.println("========================");
                    log.warn("path=>{}", httpPathUrl);
                    log.warn("method=>{}", httpMethod);
                    log.warn("query params=>{}", httpQueryParams);
                    log.warn("headers=>{}", httpHeaders);
                    log.warn("body=>{}", body);
                    System.out.println("========================");

                    var queryParams = httpRequestRepository.findByPathUrlAndMethodAndEnabled(request.getPath().toString(), request.getMethod().name(), true)
                            .collect(Collectors.toList())
                            .flatMapIterable(list -> list.stream().filter(entity -> {
                                        return !getQueryParams(entity.getQueryParam()).keySet()
                                                .stream()
                                                .filter(httpQueryParams::containsKey)
                                                .collect(Collectors.toMap(Function.identity(), httpQueryParams::get))
                                                .isEmpty();
                                    })
                                    .toList());

                    var headers = queryParams
                            .filter(entity -> {
                                return !getQueryParams(entity.getRequestHeader())
                                        .entrySet().stream().filter(key -> httpHeaders.containsKey(key.getKey()))
                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).isEmpty();
                            });

                    var bodyFilter = headers.filter(entity -> ObjectMapperUtil.getJsonNode(entity.getRequestBody()).equals(httpBody));

                    var modifyResponse = bodyFilter.flatMap(requestEntity -> {
                        log.info("Request ID: {}", requestEntity.getId());
                        return httpResponseRepository.findByHttpRequestIdAndEnabled(requestEntity.getId(), true)
                                .flatMap(responseEntity -> {
                                    if (responseEntity.getResponseTimeInMillis() != null) {
                                        try {
                                            TimeUnit.MILLISECONDS.sleep(responseEntity.getResponseTimeInMillis());
                                        } catch (InterruptedException ie) {
                                            log.error("InterruptedException: ", ie);
                                            Thread.currentThread().interrupt();
                                        }
                                    }
                                    log.info("Response ID: {}", responseEntity.getId());
                                    exchange.getResponse().setStatusCode(HttpStatus.valueOf(responseEntity.getHttpStatusCode()));
                                    exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
                                    return exchange.getResponse().writeWith(Mono.fromSupplier(() -> {
                                        return exchange.getResponse().bufferFactory().wrap(responseEntity.getBody().getBytes(StandardCharsets.UTF_8));
                                    }));
                                });
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
