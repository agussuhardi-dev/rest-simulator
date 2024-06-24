package io.github.dev.agussuhardi.simulator.dashboard.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HttpRequestDTO implements Serializable {
    @Serial
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
