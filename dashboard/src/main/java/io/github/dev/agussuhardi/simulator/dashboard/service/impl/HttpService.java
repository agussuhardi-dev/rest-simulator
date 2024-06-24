package io.github.dev.agussuhardi.simulator.dashboard.service.impl;

import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpDTO;
import io.github.dev.agussuhardi.simulator.dashboard.entity.Http;
import io.github.dev.agussuhardi.simulator.dashboard.repository.HttpRepository;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpQueryVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class HttpService {

    private final HttpRepository httpRepository;

    public HttpDTO save(HttpVO vO) {
        Http bean = httpRepository.findById(vO.getId()).orElse(new Http());
        BeanUtils.copyProperties(vO, bean, Http.Fields.createdAt, Http.Fields.updatedAt, Http.Fields.deleted);
        bean = httpRepository.save(bean);
        return toDTO(bean);
    }

    public void delete(String id) {
        httpRepository.deleteById(id);
    }

    public HttpDTO getById(String id) {
        Http original = requireOne(id);
        return toDTO(original);
    }

    public Page<HttpDTO> query(HttpQueryVO vO, Pageable pageable) {
        return httpRepository.findAll(pageable).map(this::toDTO);
    }

    private HttpDTO toDTO(Http original) {
        HttpDTO bean = new HttpDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Http requireOne(String id) {
        return httpRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
