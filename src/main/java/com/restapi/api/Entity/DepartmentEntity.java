package com.restapi.api.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor @Builder
@Table(name="DepartmentTable")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @JsonProperty("isActive")
    private Boolean isActive;
    @CreationTimestamp
    private LocalDate createdAt;
    private String hodName;
    private String collegeName;
}
