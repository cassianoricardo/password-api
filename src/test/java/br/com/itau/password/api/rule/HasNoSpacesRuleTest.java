package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HasNoSpacesRuleTest extends SpringUnitTest {

    @Autowired
    private HasNoSpacesRule hasNoSpacesRule;

    @Test
    @DisplayName("Valida se a senha possue espaços em branco")
    void validate_password_with_white_space() {
        assertFalse(hasNoSpacesRule.validate("abc defg"));
    }

    @Test
    @DisplayName("Valida se a senha possue não espaços em branco")
    void validate_password_without_white_space() {
        assertTrue(hasNoSpacesRule.validate("abcdefgg"));
    }
}