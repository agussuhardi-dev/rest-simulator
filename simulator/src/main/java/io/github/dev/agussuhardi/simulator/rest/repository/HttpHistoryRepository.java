package io.github.dev.agussuhardi.simulator.rest.repository;

import io.github.dev.agussuhardi.simulator.rest.entity.HttpHistory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author agussuhardi
 * {@code @created} 6/21/24 8:33 PM
 * {@code @project} simulator
 */
public interface HttpHistoryRepository extends ReactiveCrudRepository<HttpHistory, Long> {

}
