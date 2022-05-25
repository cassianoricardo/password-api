package br.com.itau.password.api.app.service;

import br.com.itau.password.api.SpringTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordServiceTest extends SpringTest {

    @Autowired
    private PasswordService passwordService;

    @Test
    void isValid_with_all_character_valid() {
        assertTrue(passwordService.isValid("Abcd1234*"));
    }

    @Test
    void isValid_with_one_character_is_not_valid() {
        assertFalse(passwordService.isValid("Abcd1234* "));
    }
}