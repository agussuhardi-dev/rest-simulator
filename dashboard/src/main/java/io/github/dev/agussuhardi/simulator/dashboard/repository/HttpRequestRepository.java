package io.github.dev.agussuhardi.simulator.dashboard.repository;

import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HttpRequestRepository extends JpaRepository<HttpRequest, String>, JpaSpecificationExecutor<HttpRequest> {

}
