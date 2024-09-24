package com.itau.backend.challenge.demo.infra.controllers.dtos;

import org.springframework.http.HttpStatusCode;

public record ValidatePasswordResponseDto(boolean valid, String msg) {
}
