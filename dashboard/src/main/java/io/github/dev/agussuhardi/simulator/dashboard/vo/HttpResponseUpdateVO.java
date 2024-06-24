package io.github.dev.agussuhardi.simulator.dashboard.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class HttpResponseUpdateVO extends HttpResponseVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
