package com.itau.backend.challenge.demo.infra.controllers;

import com.itau.backend.challenge.demo.infra.controllers.dtos.ValidatePasswordRequestDto;
import com.itau.backend.challenge.demo.infra.controllers.dtos.ValidatePasswordResponseDto;

public class PasswordDtoMapper {

    ValidatePasswordResponseDto toResponse(boolean valid, String msg) {
        return new ValidatePasswordResponseDto(valid, msg);
    }

    String toDomain(ValidatePasswordRequestDto request) {
        return request.password();
    }
}
