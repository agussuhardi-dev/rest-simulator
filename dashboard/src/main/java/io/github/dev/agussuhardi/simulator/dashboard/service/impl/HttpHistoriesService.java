package io.github.dev.agussuhardi.simulator.dashboard.service.impl;

import io.github.dev.agussuhardi.simulator.dashboard.dto.HttpHistoriesDTO;
import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpHistories;
import io.github.dev.agussuhardi.simulator.dashboard.repository.HttpHistoriesRepository;
import io.github.dev.agussuhardi.simulator.dashboard.vo.HttpHistoriesQueryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HttpHistoriesService {

    private final HttpHistoriesRepository httpHistoriesRepository;


    public Page<HttpHistoriesDTO> query(HttpHistoriesQueryVO vO, Pageable pageable) {
        return httpHistoriesRepository.findAll(pageable).map(this::toDTO);
    }

    private HttpHistoriesDTO toDTO(HttpHistories original) {
        HttpHistoriesDTO bean = new HttpHistoriesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

}
