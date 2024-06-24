package io.github.dev.agussuhardi.simulator.dashboard.service.impl;

import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpRequestDTO;
import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpResponseDTO;
import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpRequest;
import io.github.dev.agussuhardi.simulator.dashboard.repository.HttpRequestRepository;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpRequestQueryVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpRequestUpdateVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpRequestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class HttpRequestService {

    private final HttpRequestRepository httpRequestRepository;

    public void add(HttpRequestVO vO) {
        HttpRequest bean = new HttpRequest();
        BeanUtils.copyProperties(vO, bean);
        httpRequestRepository.save(bean);
    }

    public void delete(String id) {
        httpRequestRepository.deleteById(id);
    }

    public void update(String id, HttpRequestUpdateVO vO) {
        HttpRequest bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        httpRequestRepository.save(bean);
    }

    public HttpRequestDTO getById(String id) {
        HttpRequest original = requireOne(id);
        return toDTO(original);
    }

    public Page<HttpRequestDTO> query(HttpRequestQueryVO vO, Pageable pageable) {
        return httpRequestRepository.findAll(pageable).map(this::toDTO);
    }

    private HttpRequestDTO toDTO(HttpRequest original) {
        HttpRequestDTO bean = new HttpRequestDTO();
        BeanUtils.copyProperties(original, bean);

        if (original.getHttpResponse() != null) {
            var responseDTO = new HttpResponseDTO();
            BeanUtils.copyProperties(original.getHttpResponse(), responseDTO);
            bean.setResponse(responseDTO);
        }

        return bean;
    }

    private HttpRequest requireOne(String id) {
        return httpRequestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
