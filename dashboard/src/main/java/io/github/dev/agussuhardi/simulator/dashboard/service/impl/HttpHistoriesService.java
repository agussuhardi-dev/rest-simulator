package io.github.dev.agussuhardi.simulator.dashboard.service.impl;

import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpHistoriesDTO;
import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpHistories;
import io.github.dev.agussuhardi.simulator.dashboard.repository.HttpHistoriesRepository;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpHistoriesQueryVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpHistoriesUpdateVO;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpHistoriesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class HttpHistoriesService {

    @Autowired
    private HttpHistoriesRepository httpHistoriesRepository;

    public String save(HttpHistoriesVO vO) {
        HttpHistories bean = new HttpHistories();
        BeanUtils.copyProperties(vO, bean);
        bean = httpHistoriesRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        httpHistoriesRepository.deleteById(id);
    }

    public void update(String id, HttpHistoriesUpdateVO vO) {
        HttpHistories bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        httpHistoriesRepository.save(bean);
    }

    public HttpHistoriesDTO getById(String id) {
        HttpHistories original = requireOne(id);
        return toDTO(original);
    }

    public Page<HttpHistoriesDTO> query(HttpHistoriesQueryVO vO, Pageable pageable) {
        return httpHistoriesRepository.findAll(pageable).map(this::toDTO);
    }

    private HttpHistoriesDTO toDTO(HttpHistories original) {
        HttpHistoriesDTO bean = new HttpHistoriesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private HttpHistories requireOne(String id) {
        return httpHistoriesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
