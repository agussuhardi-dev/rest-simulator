package io.github.dev.agussuhardi.simulator.dashboard.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class HttpRequestUpdateVO extends HttpRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

}