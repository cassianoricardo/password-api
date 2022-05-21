package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AtLeastOneUpperCaseLetterTest extends SpringUnitTest {

    @Autowired
    private AtLeastOneUpperCaseLetter atLeastOneUpperCaseLetter;

    @Test
    @DisplayName("Valida se a senha possue ao menos uma letras maiuscula")
    void validate_password_with_upper_case_letter() {
        assertTrue(atLeastOneUpperCaseLetter.validate("Abcdefg"));
    }

    @Test
    @DisplayName("Valida se a senha não possue letras maiuscula")
    void validate_password_without_upper_case_letter() {
        assertFalse(atLeastOneUpperCaseLetter.validate("abcdefg"));
    }
}