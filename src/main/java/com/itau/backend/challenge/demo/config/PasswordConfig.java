package com.itau.backend.challenge.demo.config;

import com.itau.backend.challenge.demo.app.usecases.ValidatePasswordUseCase;
import com.itau.backend.challenge.demo.infra.controllers.PasswordDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordConfig {

    @Bean
    ValidatePasswordUseCase validatePasswordUseCase() {
        return new ValidatePasswordUseCase();
    }

    @Bean
    PasswordDtoMapper passwordDtoMapper() {
        return new PasswordDtoMapper();
    }

}
