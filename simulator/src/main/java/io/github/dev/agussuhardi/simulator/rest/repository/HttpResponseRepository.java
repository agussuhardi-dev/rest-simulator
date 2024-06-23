package io.github.dev.agussuhardi.simulator.rest.repository;

import io.github.dev.agussuhardi.simulator.rest.entity.HttpResponse;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author agussuhardi
 * {@code @created} 6/21/24 8:33 PM
 * {@code @project} simulator
 */
public interface HttpResponseRepository extends ReactiveCrudRepository<HttpResponse, String> {

    Flux<HttpResponse> findByHttpRequestIdAndEnabled(String httpRequestId, boolean enabled);
}
