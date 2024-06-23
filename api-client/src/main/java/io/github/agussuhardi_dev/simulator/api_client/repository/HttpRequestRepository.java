package io.github.agussuhardi_dev.simulator.api_client.repository;

import io.github.agussuhardi_dev.simulator.api_client.entiry.HttpRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HttpRequestRepository extends JpaRepository<HttpRequest, String>, JpaSpecificationExecutor<HttpRequest> {

}
