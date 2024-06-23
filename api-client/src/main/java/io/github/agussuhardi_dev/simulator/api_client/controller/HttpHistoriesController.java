package io.github.agussuhardi_dev.simulator.api_client.controller;

import io.github.agussuhardi_dev.simulator.api_client.dto.HttpHistoriesDTO;
import io.github.agussuhardi_dev.simulator.api_client.service.impl.HttpHistoriesService;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpHistoriesQueryVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpHistoriesUpdateVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpHistoriesVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/httpHistories")
public class HttpHistoriesController {

    @Autowired
    private HttpHistoriesService httpHistoriesService;

    @PostMapping
    public String save(@Valid @RequestBody HttpHistoriesVO vO) {
        return httpHistoriesService.save(vO);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        httpHistoriesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody HttpHistoriesUpdateVO vO) {
        httpHistoriesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public HttpHistoriesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return httpHistoriesService.getById(id);
    }

    @GetMapping
    public Page<HttpHistoriesDTO> query(@Valid HttpHistoriesQueryVO vO) {
        return httpHistoriesService.query(vO);
    }
}
