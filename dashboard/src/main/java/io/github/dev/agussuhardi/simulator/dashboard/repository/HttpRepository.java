package io.github.dev.agussuhardi.simulator.dashboard.repository;

import io.github.dev.agussuhardi.simulator.dashboard.entity.Http;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HttpRepository extends JpaRepository<Http, String>, JpaSpecificationExecutor<Http> {

}
