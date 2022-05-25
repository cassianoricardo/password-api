package br.com.itau.password.api.enums;

import br.com.itau.password.api.app.rule.HasNoSpacesRule;
import br.com.itau.password.api.app.rule.AtLeastNineCharactersRule;
import br.com.itau.password.api.app.rule.AtLeastOneLowerCaseLetterRule;
import br.com.itau.password.api.app.rule.AtLeastOneSpecialCharacterRule;
import br.com.itau.password.api.app.rule.AtLeastOneUpperCaseLetterRule;
import br.com.itau.password.api.app.rule.NotHaveRepeatedCharactersRule;
import br.com.itau.password.api.app.rule.PasswordRule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PasswordRuleEnum {

        AT_LEAST_ONE_UPPERCASE_LETTER(new AtLeastOneUpperCaseLetterRule()),

        AT_LEAST_ONE_LOWERCASE_LETTER(new AtLeastOneLowerCaseLetterRule()),

        AT_LEAST_ONE_SPECIAL_CHARACTER(new AtLeastOneSpecialCharacterRule()),

        AT_LEAST_NINE_CHARACTERS(new AtLeastNineCharactersRule()),

        HAVE_NON_REPEATING_CHARACTERS(new NotHaveRepeatedCharactersRule()),

        HAVE_NON_SPACES(new HasNoSpacesRule());

        private final PasswordRule rule;
}
