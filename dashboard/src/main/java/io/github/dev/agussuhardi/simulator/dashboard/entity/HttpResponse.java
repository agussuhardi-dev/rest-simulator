package io.github.dev.agussuhardi.simulator.dashboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "http_response")
public class HttpResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "http_status_code", nullable = false)
    private Integer httpStatusCode;

    @Column(name = "response_time_in_millis", nullable = false)
    private BigDecimal responseTimeInMillis;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "created_at", nullable = false)
    private BigDecimal createdAt;

    @Column(name = "updated_at")
    private BigDecimal updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "http_request_id", nullable = false)
    private String httpRequestId;

}
