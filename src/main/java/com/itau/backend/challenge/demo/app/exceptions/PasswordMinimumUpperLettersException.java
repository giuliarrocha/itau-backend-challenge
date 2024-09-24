package com.itau.backend.challenge.demo.app.exceptions;

public class PasswordMinimumUpperLettersException extends PasswordException {

    public PasswordMinimumUpperLettersException() {
        super("Senha deve conter pelo menos 1 letra maiúscula");
    }
}
