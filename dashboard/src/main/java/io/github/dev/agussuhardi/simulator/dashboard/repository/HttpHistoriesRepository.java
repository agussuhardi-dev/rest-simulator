package io.github.dev.agussuhardi.simulator.dashboard.repository;

import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpHistories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HttpHistoriesRepository extends JpaRepository<HttpHistories, String>, JpaSpecificationExecutor<HttpHistories> {

}
