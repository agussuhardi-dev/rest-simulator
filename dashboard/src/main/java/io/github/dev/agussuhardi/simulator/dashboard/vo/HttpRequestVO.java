package io.github.dev.agussuhardi.simulator.dashboard.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class HttpRequestVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "pathUrl can not null")
    private String pathUrl;

    @NotNull(message = "header can not null")
    private String header;

    @NotNull(message = "body can not null")
    private String body;

    private Boolean enabled;

    private String method;

    @NotNull(message = "queryParam can not null")
    private String queryParam;

    public Boolean getEnabled() {
        if (enabled == null) return true;
        return enabled;
    }
}
