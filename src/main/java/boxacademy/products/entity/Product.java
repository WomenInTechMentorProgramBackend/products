package boxacademy.products.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "product_code", length = 30, nullable = false, unique = true)
    private String productCode;

    @Column(name = "name", length = 30, nullable = false, unique = true)
    private String name;

    @Column(name = "price", length = 30, nullable = false, unique = true)
    private String price;

    @Column(name = "image_link", length = 255, nullable = true, unique = true)
    private String imageLink;

    @Column(name = "count", nullable = false)
    private String count;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "is_active", nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private Boolean isActive = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", length = 50, nullable = false)
    private String createdBy;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;
}
