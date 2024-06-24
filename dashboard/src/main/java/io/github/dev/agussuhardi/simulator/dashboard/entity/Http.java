package io.github.dev.agussuhardi.simulator.dashboard.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "http")
@FieldNameConstants
public class Http implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @GeneratedValue
    private String id;

    @Column(name = "request_path_url", nullable = false)
    private String requestPathUrl;

    @Column(name = "request_method", nullable = false)
    private String requestMethod;

    @Column(name = "request_query_param", nullable = false, columnDefinition = "JSONB")
    @Type(JsonType.class)
    private String requestQueryParamJSONB;

    @Column(name = "request_header", nullable = false, columnDefinition = "JSONB")
    @Type(JsonType.class)
    private String requestHeaderJSONB;

    @Column(name = "request_body", nullable = false, columnDefinition = "JSONB")
    @Type(JsonType.class)
    private String requestBodyJSONB;

    @Embedded
    private HttpResponse response;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;


    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            this.createdAt = System.currentTimeMillis();
            this.deleted = false;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = System.currentTimeMillis();
    }

}
