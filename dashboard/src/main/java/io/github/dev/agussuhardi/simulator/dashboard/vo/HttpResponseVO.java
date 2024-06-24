package io.github.dev.agussuhardi.simulator.dashboard.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class HttpResponseVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private String id;

    @NotNull(message = "header can not null")
    private String header;

    @NotNull(message = "body can not null")
    private String body;

    @NotNull(message = "httpStatusCode can not null")
    private Integer httpStatusCode;

    @NotNull(message = "responseTimeInMillis can not null")
    private BigDecimal responseTimeInMillis;

    @NotNull(message = "enabled can not null")
    private Boolean enabled;

    @NotNull(message = "createdAt can not null")
    private BigDecimal createdAt;

    private BigDecimal updatedAt;

    @NotNull(message = "deleted can not null")
    private Boolean deleted;

    @NotNull(message = "httpRequestId can not null")
    private String httpRequestId;

}
