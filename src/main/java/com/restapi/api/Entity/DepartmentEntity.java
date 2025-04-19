package com.restapi.api.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
@Table(
        name="DepartmentTable",
        schema = "College Department",
        uniqueConstraints = {@UniqueConstraint(columnNames = "hodName")},
        indexes = {
                @Index(name = "idx_title",columnList = "title"),
                @Index(name = "idx_hodName",columnList = "hodName")
        }
)
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @JsonProperty("isActive")
    private Boolean isActive;
    @CreationTimestamp
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;
    private String hodName;
    private String collegeName;
}
