package com.itau.backend.challenge.demo.app.exceptions;

public class PasswordRepeatedCharactersException extends PasswordException {

    public PasswordRepeatedCharactersException() {
        super("Senha não deve conter caracteres repetidos");
    }
}
