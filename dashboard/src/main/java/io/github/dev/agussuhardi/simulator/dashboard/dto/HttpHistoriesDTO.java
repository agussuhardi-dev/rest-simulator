package io.github.dev.agussuhardi.simulator.dashboard.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class HttpHistoriesDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int id;

    private String requestPathUrl;

    private String requestMethod;

    private String requestQueryParam;

    private String requestHeader;

    private String requestBody;

    private Long createdAt;

}
