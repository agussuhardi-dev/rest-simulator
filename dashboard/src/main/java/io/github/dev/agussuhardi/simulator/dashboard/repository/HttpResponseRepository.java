package io.github.dev.agussuhardi.simulator.dashboard.repository;

import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HttpResponseRepository extends JpaRepository<HttpResponse, String>, JpaSpecificationExecutor<HttpResponse> {

}
