package com.itau.backend.challenge.demo.app.exceptions;

public class EmptyPasswordException extends PasswordException {

    public EmptyPasswordException() {
        super("Senha vazia ou sem caracteres válidos");
    }
}
