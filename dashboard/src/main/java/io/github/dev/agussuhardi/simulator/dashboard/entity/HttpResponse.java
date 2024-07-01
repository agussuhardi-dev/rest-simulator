package io.github.dev.agussuhardi.simulator.dashboard.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 * @author agussuhardi
 * {@code @created} 6/24/24 11:50 AM
 * {@code @project} dashboard
 */
@Embeddable
@Data
public class HttpResponse {

    @Column(name = "response_header", nullable = false, columnDefinition = "JSONB")
    @Type(JsonType.class)
    private String header;

    @Column(name = "response_body", nullable = false, columnDefinition = "JSONB")
    @Type(JsonType.class)
    private String body;

    @Column(name = "response_http_status_code", nullable = false)
    private int httpStatusCode;

    @Column(name = "response_time_in_millis", nullable = false)
    private long responseTimeInMillis;
}
