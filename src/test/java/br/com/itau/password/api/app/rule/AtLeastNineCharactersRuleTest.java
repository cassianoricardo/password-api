package br.com.itau.password.api.app.rule;

import br.com.itau.password.api.SpringTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AtLeastNineCharactersRuleTest extends SpringTest {

    @Autowired
    private AtLeastNineCharactersRule atLeastNineCharactersRule;

    @Test
    @DisplayName("Valida se a senha possue nove caracteres")
    void validate_password_with_nine_characters() {
        assertTrue(atLeastNineCharactersRule.validate("123456789"));
    }

    @Test
    @DisplayName("Valida se a senha possue mais de nove caracteres")
    void validate_password_longer_than_nine_characters() {
        assertTrue(atLeastNineCharactersRule.validate("0123456789"));
    }

    @Test
    @DisplayName("Valida se a senha possue menos de nove caracteres")
    void validate_password_less_than_nine_characters() {
        assertFalse(atLeastNineCharactersRule.validate("12345678"));
    }
}