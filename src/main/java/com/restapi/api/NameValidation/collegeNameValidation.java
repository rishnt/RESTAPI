package com.restapi.api.NameValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy =CollegeNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)

public @interface collegeNameValidation {
    String message() default "the college name is not correct";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
