package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AtLeastOneSpecialCharacterTest extends SpringUnitTest {

    @Autowired
    private AtLeastOneSpecialCharacter atLeastOneSpecialCharacter;

    @Test
    @DisplayName("Valida se a senha que possue interrogacao !")
    void validate_password_with_interrogation() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg!"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de adição +")
    void validate_password_with_addition() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg+"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de subtracao -")
    void validate_password_with_subtraction() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg-"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o parenteses esquerdo (")
    void validate_password_with_left_parentheses() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg("));
    }

    @Test
    @DisplayName("Valida se a senha que possue o parenteses direito )")
    void validate_password_with_right_parentheses() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg)"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter cerquilha #")
    void validate_password_with_pounds() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg#"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter dolar $")
    void validate_password_with_dollar() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg$"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter e comercial &")
    void validate_password_with_and_commercial() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg&"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de arroba @")
    void validate_password_with_at_sign() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg@"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de porcentagem %")
    void validate_password_with_percentage() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg%"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de acento circunflexo ^")
    void validate_password_with_circumflex_accent() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg^"));
    }

    @Test
    @DisplayName("Valida se a senha que possue o caracter de asterisco *")
    void validate_password_with_asterisk() {
        assertTrue(atLeastOneSpecialCharacter.validate("abcdefg*"));
    }


    @Test
    @DisplayName("Valida se a senha que não possue ao menos um dos seguintes caracteres: ! @ # $ % ^ & * ( ) - +")
    void validate_password_without_specific_special_characters() {
        assertFalse(atLeastOneSpecialCharacter.validate("=[];:|{}"));
    }

}