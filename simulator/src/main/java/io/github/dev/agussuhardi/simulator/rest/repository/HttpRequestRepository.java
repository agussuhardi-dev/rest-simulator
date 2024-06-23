package io.github.dev.agussuhardi.simulator.rest.repository;

import io.github.dev.agussuhardi.simulator.rest.entity.HttpRequest;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author agussuhardi
 * {@code @created} 6/21/24 8:33 PM
 * {@code @project} simulator
 */
public interface HttpRequestRepository extends ReactiveCrudRepository<HttpRequest, String> {

    Flux<HttpRequest> findByPathUrlAndMethodAndEnabled(String pathUrl, String method, boolean enabled);
}
