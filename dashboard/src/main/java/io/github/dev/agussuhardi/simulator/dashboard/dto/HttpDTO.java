package io.github.dev.agussuhardi.simulator.dashboard.dto;


import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpResponse;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class HttpDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private String requestPathUrl;

    private String requestMethod;

    private String requestQueryParamJSONB;

    private String requestHeaderJSONB;

    private String requestBodyJSONB;

    private HttpResponse response;

    private Long createdAt;

    private Long updatedAt;

}
