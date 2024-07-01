package io.github.dev.agussuhardi.simulator.dashboard.vo;

import io.github.dev.agussuhardi.simulator.dashboard.entity.HttpResponse;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class HttpVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @NotNull(message = "pathUrl can not null")
    private String requestPathUrl;

    @NotNull(message = "method can not null")
    private String requestMethod;

    @NotNull(message = "queryParam can not null")
    private String requestQueryParamJSONB;

    @NotNull(message = "header can not null")
    private String requestHeaderJSONB;

    @NotNull(message = "body can not null")
    private String requestBodyJSONB;

    private HttpResponse response;


}
