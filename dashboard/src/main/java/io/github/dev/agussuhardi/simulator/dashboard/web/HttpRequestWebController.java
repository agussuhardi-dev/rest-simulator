package io.github.dev.agussuhardi.simulator.dashboard.web;

import io.github.dev.agussuhardi.simulator.dashboard.config.GlobalApiResponse;
import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpRequestDTO;
import io.github.dev.agussuhardi.simulator.dashboard.service.impl.HttpRequestService;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpRequestQueryVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpRequestVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author agussuhardii
 * {@code @created} 29/08/23/08/2023 :11
 * {@code @project} inventory
 */

@RestController
@RequestMapping("web/api/v1/http/requests")
@Slf4j
@RequiredArgsConstructor
@Validated
public class HttpRequestWebController {

    private final HttpRequestService httpRequestService;

    @GetMapping()
    public ResponseEntity<Page<HttpRequestDTO>> query(HttpRequestQueryVO vo, Pageable pageable) {
        return new GlobalApiResponse<>(httpRequestService.query(vo, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid HttpRequestVO vo) {
        httpRequestService.add(vo);
        return new GlobalApiResponse<>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable String id) {
        return new GlobalApiResponse<>(httpRequestService.getById(id), HttpStatus.CREATED);
    }
}
