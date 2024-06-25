package io.github.dev.agussuhardi.simulator.rest.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
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
@Table("http_history")
public class HttpHistory implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @Column("request_path_url")
    private String requestPathUrl;

    @Column("request_method")
    private String requestMethod;

    @Column("request_query_param")
    private String requestQueryParamJSONB;

    @Column("request_header")
    private String requestHeaderJSONB;

    @Column("request_body")
    private String requestBodyJSONB;

    @Column("created_at")
    private long createdAt;


}
