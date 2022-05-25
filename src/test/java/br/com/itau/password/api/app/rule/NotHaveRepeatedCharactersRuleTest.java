package br.com.itau.password.api.app.rule;

import br.com.itau.password.api.SpringTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotHaveRepeatedCharactersRuleTest extends SpringTest {

    @Autowired
    private NotHaveRepeatedCharactersRule notHaveRepeatedCharactersRule;

    @Test
    @DisplayName("Valida se a senha possue caracteres repetidos")
    void validate_password_with_character_repeated() {
        assertFalse(notHaveRepeatedCharactersRule.validate("abcdefgg"));
    }

    @Test
    @DisplayName("Valida se a senha não possue caracteres repetidos")
    void validate_password_without_character_repeated() {
        assertTrue(notHaveRepeatedCharactersRule.validate("abcdefg"));
    }
}