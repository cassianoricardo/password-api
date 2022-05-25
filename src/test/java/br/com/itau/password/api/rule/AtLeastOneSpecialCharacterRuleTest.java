package br.com.itau.password.api.rule;

import br.com.itau.password.api.SpringUnitTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AtLeastOneSpecialCharacterRuleTest extends SpringUnitTest {

    @Autowired
    private AtLeastOneSpecialCharacterRule atLeastOneSpecialCharacterRule;

    static Stream<Arguments> passwordsAndExpectedOutputSuccessProvider() {
        return Stream.of(
                arguments("senha!", true),
                arguments("senha@", true),
                arguments("senha#", true),
                arguments("senha$", true),
                arguments("senha%", true),
                arguments("senha^", true),
                arguments("senha&", true),
                arguments("senha*", true),
                arguments("senha(", true),
                arguments("senha)", true),
                arguments("senha+", true),
                arguments("senha-", true)
        );
    }

    static Stream<Arguments> passwordsAndExpectedOutputFailProvider() {
        return Stream.of(
                arguments("senha=", false),
                arguments("senha[", false),
                arguments("senha]", false),
                arguments("senha;", false),
                arguments("senha:", false),
                arguments("senha|", false),
                arguments("senha{", false),
                arguments("senha}", false),
                arguments("senha¨", false),
                arguments("senha'", false),
                arguments("senha§", false),
                arguments("senha~", false),
                arguments("senha´", false)
        );
    }

    @MethodSource("passwordsAndExpectedOutputSuccessProvider")
    @ParameterizedTest(name = "Valida se a senha \"{0}\" possue ao menos um dos seguintes caracteres: ! @ # $ % ^ & * ( ) - +")
    void validate_password_with_specific_special_characters(String password, boolean outputExpected) {
        assertEquals(atLeastOneSpecialCharacterRule.validate(password), outputExpected);
    }

    @MethodSource("passwordsAndExpectedOutputFailProvider")
    @ParameterizedTest(name ="Valida se a senha \"{0}\" não possue ao menos um dos seguintes caracteres: ! @ # $ % ^ & * ( ) - +")
    void validate_password_without_specific_special_characters(String password, boolean outputExpected) {
        assertEquals(atLeastOneSpecialCharacterRule.validate(password),outputExpected);
    }

}