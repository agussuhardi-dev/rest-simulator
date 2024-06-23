package io.github.agussuhardi_dev.simulator.api_client.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class HttpRequestVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private String id;

    @NotNull(message = "pathUrl can not null")
    private String pathUrl;

    @NotNull(message = "requestHeaders can not null")
    private String requestHeaders;

    @NotNull(message = "requestBody can not null")
    private String requestBody;

    @NotNull(message = "enabled can not null")
    private Boolean enabled;

    @NotNull(message = "createdAt can not null")
    private long createdAt;

    private long updatedAt;


}
