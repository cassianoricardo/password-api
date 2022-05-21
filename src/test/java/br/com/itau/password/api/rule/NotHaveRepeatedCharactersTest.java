package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NotHaveRepeatedCharactersTest extends SpringUnitTest {

    @Autowired
    private NotHaveRepeatedCharacters notHaveRepeatedCharacters;

    @Test
    @DisplayName("Valida se a senha possue caracteres repetidos")
    void validate_password_with_character_repeated() {
        assertFalse(notHaveRepeatedCharacters.validate("abcdefgg"));
    }

    @Test
    @DisplayName("Valida se a senha não possue caracteres repetidos")
    void validate_password_without_character_repeated() {
        assertTrue(notHaveRepeatedCharacters.validate("abcdefg"));
    }
}