package io.github.agussuhardi_dev.simulator.api_client.controller;

import io.github.agussuhardi_dev.simulator.api_client.dto.HttpRequestDTO;
import io.github.agussuhardi_dev.simulator.api_client.service.impl.HttpRequestService;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpRequestQueryVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpRequestUpdateVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpRequestVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/httpRequest")
public class HttpRequestController {

    @Autowired
    private HttpRequestService httpRequestService;

    @PostMapping
    public String save(@Valid @RequestBody HttpRequestVO vO) {
        return httpRequestService.save(vO);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        httpRequestService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody HttpRequestUpdateVO vO) {
        httpRequestService.update(id, vO);
    }

    @GetMapping("/{id}")
    public HttpRequestDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return httpRequestService.getById(id);
    }

    @GetMapping
    public Page<HttpRequestDTO> query(@Valid HttpRequestQueryVO vO) {
        return httpRequestService.query(vO);
    }
}
