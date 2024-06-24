package io.github.dev.agussuhardi.simulator.dashboard.vo;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HttpRequestQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String pathUrl;

    private String requestHeader;

    private String requestBody;

    private Boolean enabled;

    private BigDecimal createdAt;

    private BigDecimal updatedAt;

    private Boolean deleted;

    private String method;

    private String queryParam;

}
