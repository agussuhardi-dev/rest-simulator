package io.github.agussuhardi_dev.simulator.api_client.service.impl;

import io.github.agussuhardi_dev.simulator.api_client.dto.HttpRequestDTO;
import io.github.agussuhardi_dev.simulator.api_client.entiry.HttpRequest;
import io.github.agussuhardi_dev.simulator.api_client.repository.HttpRequestRepository;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpRequestQueryVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpRequestUpdateVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpRequestVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class HttpRequestService {

    @Autowired
    private HttpRequestRepository httpRequestRepository;

    public String save(HttpRequestVO vO) {
        HttpRequest bean = new HttpRequest();
        BeanUtils.copyProperties(vO, bean);
        bean = httpRequestRepository.save(bean);
        return bean.getId();
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

    public Page<HttpRequestDTO> query(HttpRequestQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private HttpRequestDTO toDTO(HttpRequest original) {
        HttpRequestDTO bean = new HttpRequestDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private HttpRequest requireOne(String id) {
        return httpRequestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
