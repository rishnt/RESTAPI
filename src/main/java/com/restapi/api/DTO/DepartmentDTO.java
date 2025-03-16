package com.restapi.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentDTO {
    private Long id;
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;
    private String hodName;
    private String collegeName;
}
