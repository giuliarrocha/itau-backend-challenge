package com.itau.backend.challenge.demo.app.exceptions;

public class PasswordMinimumDigitsException extends PasswordException {

    public PasswordMinimumDigitsException() {
        super("Senha deve conter pelo menos 1 dígito");
    }
}
