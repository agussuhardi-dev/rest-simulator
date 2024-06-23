package io.github.agussuhardi_dev.simulator.api_client.entiry;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@SQLDelete(sql = "update http_request set is_deleted=true where id=?")
@SQLRestriction("is_deleted=false")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
@FieldNameConstants
@ToString
@Table(name = "http_request")
public class HttpRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "path_url", nullable = false)
    private String pathUrl;

    @Column(name = "request_headers", nullable = false)
    private String requestHeaders;

    @Column(name = "request_body", nullable = false)
    private String requestBody;

    @Column(name = "is_enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "created_at", nullable = false)
    private BigDecimal createdAt;

    @Column(name = "updated_at")
    private BigDecimal updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private Boolean deleted;

}
