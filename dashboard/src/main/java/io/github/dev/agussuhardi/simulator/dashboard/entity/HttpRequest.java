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
@Table(name = "http_request")
public class HttpRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "path_url", nullable = false)
    private String pathUrl;

    @Column(name = "request_header", nullable = false)
    private String requestHeader;

    @Column(name = "request_body", nullable = false)
    private String requestBody;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "created_at", nullable = false)
    private BigDecimal createdAt;

    @Column(name = "updated_at")
    private BigDecimal updatedAt;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "method", nullable = false)
    private String method;

    @Column(name = "query_param", nullable = false)
    private String queryParam;

}
