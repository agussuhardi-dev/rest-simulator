package io.github.dev.agussuhardi.simulator.dashboard.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "http_request")
public class HttpRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @GeneratedValue
    private String id;

    @Column(name = "path_url", nullable = false)
    private String pathUrl;

    @Column(name = "header", nullable = false, columnDefinition = "JSONB")
    @Type(JsonType.class)
    private String header;

    @Column(name = "body", nullable = false, columnDefinition = "JSONB")
    @Type(JsonType.class)
    private String body;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "method", nullable = false)
    private String method;

    @Column(name = "query_param", nullable = false, columnDefinition = "JSONB")
    @Type(JsonType.class)
    private String queryParam;

    @OneToOne(mappedBy = "httpRequest", cascade = CascadeType.ALL)
    private HttpResponse httpResponse;

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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        HttpRequest that = (HttpRequest) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
