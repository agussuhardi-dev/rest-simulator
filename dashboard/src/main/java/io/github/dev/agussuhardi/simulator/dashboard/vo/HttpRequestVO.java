package io.github.dev.agussuhardi.simulator.dashboard.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class HttpRequestVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private String id;

    @NotNull(message = "pathUrl can not null")
    private String pathUrl;

    @NotNull(message = "requestHeader can not null")
    private String requestHeader;

    @NotNull(message = "requestBody can not null")
    private String requestBody;

    @NotNull(message = "enabled can not null")
    private Boolean enabled;

    @NotNull(message = "createdAt can not null")
    private BigDecimal createdAt;

    private BigDecimal updatedAt;

    @NotNull(message = "deleted can not null")
    private Boolean deleted;

    @NotNull(message = "method can not null")
    private String method;

    @NotNull(message = "queryParam can not null")
    private String queryParam;

}
