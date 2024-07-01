package io.github.dev.agussuhardi.simulator.rest.repository;

import io.github.dev.agussuhardi.simulator.rest.entity.Http;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author agussuhardi
 * {@code @created} 6/21/24 8:33 PM
 * {@code @project} simulator
 */
public interface HttpRepository extends ReactiveCrudRepository<Http, String> {

    @Query("SELECT * FROM http WHERE request_method = :method AND request_path_url = :pathUrl")
    Flux<Http> findByRequestMethodAndRequestPathUrl(String method, String pathUrl);
}
