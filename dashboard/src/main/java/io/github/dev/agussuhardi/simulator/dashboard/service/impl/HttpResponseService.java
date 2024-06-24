package io.github.dev.agussuhardi.simulator.dashboard.service.impl;

import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpResponseDTO;
import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpResponse;
import io.github.dev.agussuhardi.simulator.dashboard.repository.HttpResponseRepository;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpResponseQueryVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpResponseUpdateVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class HttpResponseService {

    @Autowired
    private HttpResponseRepository httpResponseRepository;

    public String save(HttpResponseVO vO) {
        HttpResponse bean = new HttpResponse();
        BeanUtils.copyProperties(vO, bean);
        bean = httpResponseRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        httpResponseRepository.deleteById(id);
    }

    public void update(String id, HttpResponseUpdateVO vO) {
        HttpResponse bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        httpResponseRepository.save(bean);
    }

    public HttpResponseDTO getById(String id) {
        HttpResponse original = requireOne(id);
        return toDTO(original);
    }

    public Page<HttpResponseDTO> query(HttpResponseQueryVO vO, Pageable pageable) {
        return httpResponseRepository.findAll(pageable).map(this::toDTO);
    }

    private HttpResponseDTO toDTO(HttpResponse original) {
        HttpResponseDTO bean = new HttpResponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private HttpResponse requireOne(String id) {
        return httpResponseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
