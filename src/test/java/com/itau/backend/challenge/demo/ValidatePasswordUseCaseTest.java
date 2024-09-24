package com.itau.backend.challenge.demo;

import com.itau.backend.challenge.demo.app.exceptions.*;
import com.itau.backend.challenge.demo.app.usecases.ValidatePasswordUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatePasswordUseCaseTest {

    private ValidatePasswordUseCase validatePasswordUseCase;

    @BeforeEach
    void setUp() {
        validatePasswordUseCase = new ValidatePasswordUseCase();
    }

    @Test
    void shouldPassForValidPassword() {
        String validPassword = "A1bcdefg$h";
        assertDoesNotThrow(() -> validatePasswordUseCase.execute(validPassword));
    }

    @Test
    void shouldThrowEmptyPasswordExceptionForBlankPassword() {
        String blankPassword = "";
        assertThrows(EmptyPasswordException.class, () -> validatePasswordUseCase.execute(blankPassword));
    }

    @Test
    void shouldThrowPasswordMinimumCharactersException() {
        String shortPassword = "Ab1@";
        assertThrows(PasswordMinimumCharactersException.class, () -> validatePasswordUseCase.execute(shortPassword));
    }

    @Test
    void shouldThrowPasswordMinimumDigitsException() {
        String noDigitPassword = "Abcdefg$h";
        assertThrows(PasswordMinimumDigitsException.class, () -> validatePasswordUseCase.execute(noDigitPassword));
    }

    @Test
    void shouldThrowPasswordMinimumLowerLettersException() {
        String noLowercasePassword = "ABC1$DEFG";
        assertThrows(PasswordMinimumLowerLettersException.class, () -> validatePasswordUseCase.execute(noLowercasePassword));
    }

    @Test
    void shouldThrowPasswordMinimumUpperLettersException() {
        String noUppercasePassword = "abc1$defg";
        assertThrows(PasswordMinimumUpperLettersException.class, () -> validatePasswordUseCase.execute(noUppercasePassword));
    }

    @Test
    void shouldThrowPasswordMinimumSpecialCharactersException() {
        String noSpecialCharPassword = "Abcdefg1h";
        assertThrows(PasswordMinimumSpecialCharactersException.class, () -> validatePasswordUseCase.execute(noSpecialCharPassword));
    }

    @Test
    void shouldThrowPasswordBlankSpaceException() {
        String passwordWithSpace = "A1bcd ef$";
        assertThrows(PasswordBlankSpaceException.class, () -> validatePasswordUseCase.execute(passwordWithSpace));
    }

    @Test
    void shouldThrowPasswordRepeatedCharactersException() {
        String repeatedCharPassword = "A1bcdef$A";
        assertThrows(PasswordRepeatedCharactersException.class, () -> validatePasswordUseCase.execute(repeatedCharPassword));
    }

    @Test
    void shouldThrowPasswordRepeatedCharactersIgnoreCaseException() {
        String repeatedCharPassword = "AaBbCcDdEe1*";
        assertThrows(PasswordRepeatedCharactersException.class, () -> validatePasswordUseCase.execute(repeatedCharPassword));
    }

}
