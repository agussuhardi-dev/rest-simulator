package io.github.dev.agussuhardi.simulator.dashboard.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HttpResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;

    private String header;

    private String body;

    private Integer httpStatusCode;

    private BigDecimal responseTimeInMillis;

    private HttpRequestDTO request;

}
