package com.itau.backend.challenge.demo.app.exceptions;

public class PasswordMinimumSpecialCharactersException extends PasswordException {

    public PasswordMinimumSpecialCharactersException(int minimumLetters) {
        super("Senha deve conter pelo menos %d caracter especial".formatted(minimumLetters));
    }
}
