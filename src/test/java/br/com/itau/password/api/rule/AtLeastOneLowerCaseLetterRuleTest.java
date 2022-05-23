package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AtLeastOneLowerCaseLetterRuleTest extends SpringUnitTest {

    @Autowired
    private AtLeastOneLowerCaseLetterRule atLeastOneLowerCaseLetterRule;

    @Test
    @DisplayName("Valida se a senha possue ao menos uma letras minusculas")
    void validate_password_with_lower_case_letter() {
        assertTrue(atLeastOneLowerCaseLetterRule.validate("aBCDEFG"));
    }

    @Test
    @DisplayName("Valida se a senha não possue letras minusculas")
    void validate_password_without_lower_case_letter() {
        assertFalse(atLeastOneLowerCaseLetterRule.validate("ABCDEFG"));
    }
}