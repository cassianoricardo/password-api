package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AtLeastOneSpecialCharacterRuleTest extends SpringTest {

    @Autowired
    private AtLeastOneSpecialCharacterRule atLeastOneSpecialCharacterRule;

    static Stream<Arguments> passwordsAndExpectedOutputSuccessProvider() {
        return Stream.of(
                arguments("senha!"),
                arguments("senha@"),
                arguments("senha#"),
                arguments("senha$"),
                arguments("senha%"),
                arguments("senha^"),
                arguments("senha&"),
                arguments("senha*"),
                arguments("senha("),
                arguments("senha)"),
                arguments("senha+"),
                arguments("senha-")
        );
    }

    static Stream<Arguments> passwordsAndExpectedOutputFailProvider() {
        return Stream.of(
                arguments("senha="),
                arguments("senha["),
                arguments("senha]"),
                arguments("senha;"),
                arguments("senha:"),
                arguments("senha|"),
                arguments("senha{"),
                arguments("senha}"),
                arguments("senha¨"),
                arguments("senha'"),
                arguments("senha§"),
                arguments("senha~"),
                arguments("senha´")
        );
    }

    @MethodSource("passwordsAndExpectedOutputSuccessProvider")
    @DisplayName("Valida se a senha possue ao menos um dos seguintes caracteres: ! @ # $ % ^ & * ( ) - +")
    @ParameterizedTest(name = "{index} - senha = {0}")
    void validate_password_with_specific_special_characters(String password) {
        assertTrue(atLeastOneSpecialCharacterRule.validate(password));
    }

    @MethodSource("passwordsAndExpectedOutputFailProvider")
    @DisplayName("Valida se a senha não possue ao menos um dos seguintes caracteres: ! @ # $ % ^ & * ( ) - +")
    @ParameterizedTest(name = "{index} - senha = {0}")void validate_password_without_specific_special_characters(String password) {
        assertFalse(atLeastOneSpecialCharacterRule.validate(password));
    }

}