package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AtLeastNineCharactersTest extends SpringUnitTest {

    @Autowired
    private AtLeastNineCharacters atLeastNineCharacters;

    @Test
    @DisplayName("Valida se a senha possue nove caracteres")
    void validate_password_with_nine_characters() {
        assertTrue(atLeastNineCharacters.validate("123456789"));
    }

    @Test
    @DisplayName("Valida se a senha possue mais de nove caracteres")
    void validate_password_longer_than_nine_characters() {
        assertTrue(atLeastNineCharacters.validate("0123456789"));
    }

    @Test
    @DisplayName("Valida se a senha possue menos de nove caracteres")
    void validate_password_less_than_nine_characters() {
        assertFalse(atLeastNineCharacters.validate("12345678"));
    }
}