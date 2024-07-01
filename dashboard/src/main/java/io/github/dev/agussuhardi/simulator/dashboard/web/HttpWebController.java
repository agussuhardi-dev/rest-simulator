package io.github.dev.agussuhardi.simulator.dashboard.web;

import io.github.dev.agussuhardi.simulator.dashboard.config.GlobalApiResponse;
import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpDTO;
import io.github.dev.agussuhardi.simulator.dashboard.service.impl.HttpService;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpQueryVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpVO;
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
@RequestMapping("web/api/v1/http")
@Slf4j
@RequiredArgsConstructor
@Validated
public class HttpWebController {

    private final HttpService httpService;

    @GetMapping()
    public ResponseEntity<Page<HttpDTO>> query(HttpQueryVO vo, Pageable pageable) {
        return new GlobalApiResponse<>(httpService.query(vo, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid HttpVO vo) {
        return new GlobalApiResponse<>(httpService.save(vo), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable String id) {
        return new GlobalApiResponse<>(httpService.getById(id), HttpStatus.CREATED);
    }
}
