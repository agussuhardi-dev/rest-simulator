package io.github.agussuhardi_dev.simulator.api_client.repository;

import io.github.agussuhardi_dev.simulator.api_client.entiry.HttpHistories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HttpHistoriesRepository extends JpaRepository<HttpHistories, String>, JpaSpecificationExecutor<HttpHistories> {

}
