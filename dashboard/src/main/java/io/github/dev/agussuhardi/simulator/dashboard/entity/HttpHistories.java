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
@Table(name = "http_histories")
public class HttpHistories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "path_url", nullable = false)
    private String pathUrl;

    @Column(name = "request_content_type", nullable = false)
    private String requestContentType;

    @Column(name = "request_headers", nullable = false)
    private String requestHeaders;

    @Column(name = "request_body", nullable = false)
    private String requestBody;

    @Column(name = "response_headers", nullable = false)
    private String responseHeaders;

    @Column(name = "response_body", nullable = false)
    private String responseBody;

    @Column(name = "response_http_status_code", nullable = false)
    private Integer responseHttpStatusCode;

    @Column(name = "created_at", nullable = false)
    private BigDecimal createdAt;

    @Column(name = "updated_at")
    private BigDecimal updatedAt;

}
