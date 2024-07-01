package io.github.dev.agussuhardi.simulator.dashboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "http_history")
public class HttpHistories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "request_path_url")
    private String requestPathUrl;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "request_query_param")
    private String requestQueryParam;

    @Column(name = "request_header")
    private String requestHeader;

    @Column(name = "request_body")
    private String requestBody;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;

}
