package io.github.agussuhardi_dev.simulator.api_client.repository;

import io.github.agussuhardi_dev.simulator.api_client.entiry.HttpResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HttpResponseRepository extends JpaRepository<HttpResponse, String>, JpaSpecificationExecutor<HttpResponse> {

}
