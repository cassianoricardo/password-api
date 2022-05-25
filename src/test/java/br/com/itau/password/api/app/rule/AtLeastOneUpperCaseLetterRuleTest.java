package br.com.itau.password.api.app.rule;

import br.com.itau.password.api.SpringTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AtLeastOneUpperCaseLetterRuleTest extends SpringTest {

    @Autowired
    private AtLeastOneUpperCaseLetterRule atLeastOneUpperCaseLetterRule;

    @Test
    @DisplayName("Valida se a senha possue ao menos uma letras maiuscula")
    void validate_password_with_upper_case_letter() {
        assertTrue(atLeastOneUpperCaseLetterRule.validate("Abcdefg"));
    }

    @Test
    @DisplayName("Valida se a senha não possue letras maiuscula")
    void validate_password_without_upper_case_letter() {
        assertFalse(atLeastOneUpperCaseLetterRule.validate("abcdefg"));
    }
}