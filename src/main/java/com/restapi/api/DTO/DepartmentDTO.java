package com.restapi.api.DTO;

import com.restapi.api.NameValidation.Validname;
import com.restapi.api.NameValidation.collegeNameValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DepartmentDTO {
    private Long id;
    @NotBlank
    private String title;
    private Boolean isActive;
    private LocalDateTime createdAt;
    @Validname
    private String hodName;
    @Length(min=1,max = 20) @collegeNameValidation
    private String collegeName;
}
