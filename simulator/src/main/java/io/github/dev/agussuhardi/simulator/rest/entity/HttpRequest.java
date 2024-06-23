package io.github.dev.agussuhardi.simulator.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
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
@Table("http_request")
public class HttpRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String pathUrl;
    private String method;
    private String queryParam;
    private String requestHeader;
    @Column("request_body")
    private String requestBody;
    private boolean enabled;

}
