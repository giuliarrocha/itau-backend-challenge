package com.itau.backend.challenge.demo.infra.controllers;


import com.itau.backend.challenge.demo.app.exceptions.PasswordException;
import com.itau.backend.challenge.demo.app.usecases.ValidatePasswordUseCase;
import com.itau.backend.challenge.demo.infra.controllers.dtos.ValidatePasswordRequestDto;
import com.itau.backend.challenge.demo.infra.controllers.dtos.ValidatePasswordResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("password")
@AllArgsConstructor
public class PasswordController {

    private final ValidatePasswordUseCase useCase;
    private final PasswordDtoMapper mapper;

    @PostMapping("/validate")
    public ResponseEntity<ValidatePasswordResponseDto> validatePassword(@RequestBody ValidatePasswordRequestDto request) {
        try {
            useCase.execute(mapper.toDomain(request));
            return ResponseEntity.ok(mapper.toResponse(true, "Senha válida"));
        } catch (PasswordException e) {
            return ResponseEntity.badRequest().body(mapper.toResponse(false, e.getMessage()));
        }
    }
}
