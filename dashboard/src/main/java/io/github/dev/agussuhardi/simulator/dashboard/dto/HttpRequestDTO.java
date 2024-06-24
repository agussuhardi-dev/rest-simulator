package io.github.dev.agussuhardi.simulator.dashboard.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class HttpRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;

    private String pathUrl;

    private String header;

    private String body;

    private Boolean enabled;

    private Long createdAt;

    private Long updatedAt;

    private Boolean deleted;

    private String method;

    private String queryParam;

    private HttpResponseDTO response;

}
