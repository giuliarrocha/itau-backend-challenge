package com.itau.backend.challenge.demo.app.exceptions;

public class PasswordMinimumCharactersException extends PasswordException {

    public PasswordMinimumCharactersException(int minimumChars) {
        super("Senha deve conter %d ou mais caracteres".formatted(minimumChars));
    }
}
