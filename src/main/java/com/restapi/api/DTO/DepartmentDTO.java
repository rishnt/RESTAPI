package com.restapi.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restapi.api.NameValidation.Validname;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
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
    @NotBlank
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;
    @NotBlank @Validname
    private String hodName;
    @NotBlank @Length(min=1,max = 20)
    private String collegeName;
}
