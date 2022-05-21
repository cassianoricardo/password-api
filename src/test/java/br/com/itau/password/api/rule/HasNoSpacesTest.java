package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HasNoSpacesTest extends SpringUnitTest {

    @Autowired
    private HasNoSpaces hasNoSpaces;

    @Test
    @DisplayName("Valida se a senha possue espaços em branco")
    void validate_password_with_white_space() {
        assertFalse(hasNoSpaces.validate("abc defg"));
    }

    @Test
    @DisplayName("Valida se a senha possue não espaços em branco")
    void validate_password_without_white_space() {
        assertTrue(hasNoSpaces.validate("abcdefgg"));
    }
}