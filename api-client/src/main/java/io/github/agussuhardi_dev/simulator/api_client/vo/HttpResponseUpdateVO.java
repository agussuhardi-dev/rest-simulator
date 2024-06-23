package io.github.agussuhardi_dev.simulator.api_client.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class HttpResponseUpdateVO extends HttpResponseQueryVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
