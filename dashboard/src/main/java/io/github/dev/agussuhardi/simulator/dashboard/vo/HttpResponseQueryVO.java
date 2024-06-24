package io.github.dev.agussuhardi.simulator.dashboard.vo;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HttpResponseQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String header;

    private String body;

    private Integer httpStatusCode;

    private BigDecimal responseTimeInMillis;

    private Boolean enabled;

    private BigDecimal createdAt;

    private BigDecimal updatedAt;

    private Boolean deleted;

    private String httpRequestId;

}
