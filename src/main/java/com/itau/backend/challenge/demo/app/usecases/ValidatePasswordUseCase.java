package com.itau.backend.challenge.demo.app.usecases;

import com.itau.backend.challenge.demo.app.exceptions.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ValidatePasswordUseCase {

    private static final int MIN_CHARS = 9;
    private static final int MIN_SPECIAL_CHAR = 1;

    public void execute(String password) {
        validateNotBlank(password);
        validateMinimumChars(password);
        validateMinimumDigits(password);
        validateMinimumLowerLetters(password);
        validateMinimumUpperLetters(password);
        validateMinimumSpecialChars(password);
        validateBlankSpaceExistence(password);
        validateRepeatedCharacters(password);
    }

    private void validateNotBlank(String password) {
        if (password == null || password.isBlank()) {
            throw new EmptyPasswordException();
        }
    }

    private void validateMinimumChars(String password) {
        if (password.length() < MIN_CHARS) {
            throw new PasswordMinimumCharactersException(MIN_CHARS);
        }
    }

    private void validateMinimumDigits(String password) {
        if (hasNoOccurrences(password, ".*\\d.*")) {
            throw new PasswordMinimumDigitsException();
        }
    }

    private void validateMinimumLowerLetters(String password) {
        if (hasNoOccurrences(password, ".*[a-z].*")) {
            throw new PasswordMinimumLowerLettersException();
        }
    }

    private void validateMinimumUpperLetters(String password) {
        if (hasNoOccurrences(password, ".*[A-Z].*")) {
            throw new PasswordMinimumUpperLettersException();
        }
    }

    private void validateMinimumSpecialChars(String password) {
        String specialChars = "^!@#$%^&*()\\-+";
        long specialCharsCount = password.chars()
                .filter(c -> specialChars.indexOf(c) >= 0)
                .count();
        if (specialCharsCount < MIN_SPECIAL_CHAR) {
            throw new PasswordMinimumSpecialCharactersException(MIN_SPECIAL_CHAR);
        }
    }

    private void validateBlankSpaceExistence(String password) {
        if (password.contains(" ")) {
            throw new PasswordBlankSpaceException();
        }
    }

    private void validateRepeatedCharacters(String password) {
        Set<String> singleChars = new HashSet<>();
        for (char c : password.toCharArray()) {
            singleChars.add(String.valueOf(c).toLowerCase());
        }
        if (password.length() != singleChars.size()) {
            throw new PasswordRepeatedCharactersException();
        }

    }

    private boolean hasNoOccurrences(String password, String pattern) {
        return !password.matches(pattern);
    }
}
