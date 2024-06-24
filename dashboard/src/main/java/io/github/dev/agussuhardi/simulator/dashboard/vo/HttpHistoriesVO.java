package io.github.dev.agussuhardi.simulator.dashboard.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class HttpHistoriesVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private String id;

    @NotNull(message = "pathUrl can not null")
    private String pathUrl;

    @NotNull(message = "requestContentType can not null")
    private String requestContentType;

    @NotNull(message = "requestHeaders can not null")
    private String requestHeaders;

    @NotNull(message = "requestBody can not null")
    private String requestBody;

    @NotNull(message = "responseHeaders can not null")
    private String responseHeaders;

    @NotNull(message = "responseBody can not null")
    private String responseBody;

    @NotNull(message = "responseHttpStatusCode can not null")
    private Integer responseHttpStatusCode;

    @NotNull(message = "createdAt can not null")
    private BigDecimal createdAt;

    private BigDecimal updatedAt;

}
