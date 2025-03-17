package com.restapi.api.NameValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Locale;

public class CollegeNameValidator implements ConstraintValidator<collegeNameValidation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.isEmpty()||s==null){
            return true;
        }
        HashSet<String> colleges = new HashSet<>();

        colleges.add("HARVARD UNI");
        colleges.add("STANFORD UN");
        colleges.add("MICHIGAN ST");
        colleges.add("CAMBRIDGE C");
        colleges.add("OXFORD UNIV");


        for(String college: colleges){
            if(s.toUpperCase(Locale.ROOT).equals(college)){
                return true;
            }
        }
        return false;
    }
}
