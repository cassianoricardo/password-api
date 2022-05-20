package br.com.itau.password.api.enums;

import br.com.itau.password.api.rule.HasNoSpaces;
import br.com.itau.password.api.rule.AtLeastNineCharacters;
import br.com.itau.password.api.rule.AtLeastOneLowerCaseLetter;
import br.com.itau.password.api.rule.AtLeastOneSpecialCharacter;
import br.com.itau.password.api.rule.AtLeastOneUpperCaseLetter;
import br.com.itau.password.api.rule.NotHaveRepeatedCharacters;
import br.com.itau.password.api.rule.PasswordRule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PasswordRuleEnum {

        AT_LEAST_ONE_UPPERCASE_LETTER(new AtLeastOneUpperCaseLetter()),

        AT_LEAST_ONE_LOWERCASE_LETTER(new AtLeastOneLowerCaseLetter()),

        AT_LEAST_ONE_SPECIAL_CHARACTER(new AtLeastOneSpecialCharacter()),

        AT_LEAST_NINE_CHARACTERS(new AtLeastNineCharacters()),

        HAVE_NON_REPEATING_CHARACTERS(new NotHaveRepeatedCharacters()),

        HAVE_NON_SPACES(new HasNoSpaces());

        private final PasswordRule passwordRule;
}