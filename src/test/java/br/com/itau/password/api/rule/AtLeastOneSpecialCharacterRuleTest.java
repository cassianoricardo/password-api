package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AtLeastOneSpecialCharacterRuleTest extends SpringUnitTest {

    @Autowired
    private AtLeastOneSpecialCharacterRule atLeastOneSpecialCharacterRule;

    @Test
    @DisplayName("Valida se a senha que possue interrogacao !")
    void validate_password_with_interrogation() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg!"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de adição +")
    void validate_password_with_addition() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg+"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de subtracao -")
    void validate_password_with_subtraction() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg-"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o parenteses esquerdo (")
    void validate_password_with_left_parentheses() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg("));
    }

    @Test
    @DisplayName("Valida se a senha que possue o parenteses direito )")
    void validate_password_with_right_parentheses() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg)"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter cerquilha #")
    void validate_password_with_pounds() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg#"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter dolar $")
    void validate_password_with_dollar() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg$"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter e comercial &")
    void validate_password_with_and_commercial() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg&"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de arroba @")
    void validate_password_with_at_sign() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg@"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de porcentagem %")
    void validate_password_with_percentage() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg%"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de acento circunflexo ^")
    void validate_password_with_circumflex_accent() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg^"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de asterisco *")
    void validate_password_with_asterisk() {
        assertTrue(atLeastOneSpecialCharacterRule.validate("abcdefg*"));
    }


    @Test
    @DisplayName("Valida se a senha que não possue ao menos um dos seguintes caracteres: ! @ # $ % ^ & * ( ) - +")
    void validate_password_without_specific_special_characters() {
        assertFalse(atLeastOneSpecialCharacterRule.validate("=[];:|{}"));
    }

}