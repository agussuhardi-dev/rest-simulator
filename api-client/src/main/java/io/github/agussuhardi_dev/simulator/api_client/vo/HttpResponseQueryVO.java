package io.github.agussuhardi_dev.simulator.api_client.vo;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HttpResponseQueryVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private String responseHeaders;

    private String responseBody;

    private Integer responseHttpStatusCode;

    private BigDecimal responseTimeInMillis;

    private Boolean enabled;

    private BigDecimal createdAt;

    private BigDecimal updatedAt;

    private Boolean deleted;

    private String httpRequestId;

}
