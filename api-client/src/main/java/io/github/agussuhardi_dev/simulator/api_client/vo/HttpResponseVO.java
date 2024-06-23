package io.github.agussuhardi_dev.simulator.api_client.vo;

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

    @NotNull(message = "responseHeaders can not null")
    private String responseHeaders;

    @NotNull(message = "responseBody can not null")
    private String responseBody;

    @NotNull(message = "responseHttpStatusCode can not null")
    private Integer responseHttpStatusCode;

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
