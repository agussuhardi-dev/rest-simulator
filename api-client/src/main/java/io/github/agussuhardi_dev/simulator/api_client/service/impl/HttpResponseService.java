package io.github.agussuhardi_dev.simulator.api_client.service.impl;

import io.github.agussuhardi_dev.simulator.api_client.dto.HttpResponseDTO;
import io.github.agussuhardi_dev.simulator.api_client.entiry.HttpResponse;
import io.github.agussuhardi_dev.simulator.api_client.repository.HttpResponseRepository;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpResponseQueryVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpResponseUpdateVO;
import io.github.agussuhardi_dev.simulator.api_client.vo.HttpResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public Page<HttpResponseDTO> query(HttpResponseQueryVO vO) {
        throw new UnsupportedOperationException();
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
