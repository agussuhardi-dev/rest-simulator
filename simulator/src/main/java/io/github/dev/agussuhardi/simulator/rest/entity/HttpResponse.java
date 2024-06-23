package io.github.dev.agussuhardi.simulator.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author agussuhardi
 * {@code @created} 6/21/24 8:33 PM
 * {@code @project} simulator
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("http_response")
public class HttpResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String header;
    private String body;
    private Integer httpStatusCode;
    private Long responseTimeInMillis;
    private boolean enabled;
    private String httpRequestId;

}
