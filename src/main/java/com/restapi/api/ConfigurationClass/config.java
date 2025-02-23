package com.restapi.api.ConfigurationClass;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public static ModelMapper getMapper(){
        return new ModelMapper();
    }
}
