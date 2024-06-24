package io.github.dev.agussuhardi.simulator.dashboard.web;

import io.github.dev.agussuhardi.simulator.dashboard.config.GlobalApiResponse;
import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpHistoriesDTO;
import io.github.dev.agussuhardi.simulator.dashboard.repository.HttpHistoriesRepository;
import io.github.dev.agussuhardi.simulator.dashboard.service.impl.HttpHistoriesService;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpHistoriesQueryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author agussuhardii
 * {@code @created} 29/08/23/08/2023 :11
 * {@code @project} inventory
 */

@RestController
@RequestMapping("web/api/v1/http/histories")
@Slf4j
@RequiredArgsConstructor
@Validated
public class HttpHistoryWebController {

    private final HttpHistoriesService httpHistoriesService;
    private final HttpHistoriesRepository repository;

    @GetMapping()
    public ResponseEntity<Page<HttpHistoriesDTO>> query(HttpHistoriesQueryVO vo, Pageable pageable) {
        return new GlobalApiResponse<>(httpHistoriesService.query(vo, pageable), HttpStatus.OK);
    }
}
