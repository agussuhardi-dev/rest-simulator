package io.github.agussuhardi_dev.simulator.api_client.controller;

import io.github.agussuhardi_dev.simulator.api_client.dto.HttpResponseDTO;
import io.github.agussuhardi_dev.simulator.api_client.service.impl.HttpResponseService;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpResponseQueryVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpResponseUpdateVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpResponseVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/httpResponse")
public class HttpResponseController {

    @Autowired
    private HttpResponseService httpResponseService;

    @PostMapping
    public String save(@Valid @RequestBody HttpResponseVO vO) {
        return httpResponseService.save(vO);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        httpResponseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody HttpResponseUpdateVO vO) {
        httpResponseService.update(id, vO);
    }

    @GetMapping("/{id}")
    public HttpResponseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return httpResponseService.getById(id);
    }

    @GetMapping
    public Page<HttpResponseDTO> query(@Valid HttpResponseQueryVO vO) {
        return httpResponseService.query(vO);
    }
}
