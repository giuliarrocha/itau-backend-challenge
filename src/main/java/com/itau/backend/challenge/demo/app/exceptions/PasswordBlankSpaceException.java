package com.itau.backend.challenge.demo.app.exceptions;

public class PasswordBlankSpaceException extends PasswordException {

    public PasswordBlankSpaceException() {
        super("Senha não deve conter espaços em branco");
    }
}
