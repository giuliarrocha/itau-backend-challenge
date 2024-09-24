package com.itau.backend.challenge.demo.app.exceptions;

public class PasswordMinimumLowerLettersException extends PasswordException {

    public PasswordMinimumLowerLettersException() {
        super("Senha deve conter pelo menos 1 letra minúscula");
    }
}
