package br.com.itau.password.api.service;

import br.com.itau.password.api.SpringTest;
import br.com.itau.password.api.dto.PasswordDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordServiceTest extends SpringTest {

    @Autowired
    private PasswordService passwordService;

    @Test
    void isValid_with_all_character_valid() {
        assertTrue(passwordService.isValid(PasswordDTO.builder().password("Abcd1234*").build()));
    }

    @Test
    void isValid_with_one_character_is_not_valid() {
        assertFalse(passwordService.isValid(PasswordDTO.builder().password("Abcd1234* ").build()));
    }
}