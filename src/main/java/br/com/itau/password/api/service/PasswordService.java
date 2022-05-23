package br.com.itau.password.api.service;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

import static br.com.itau.password.api.enums.PasswordRuleEnum.AT_LEAST_NINE_CHARACTERS;
import static br.com.itau.password.api.enums.PasswordRuleEnum.AT_LEAST_ONE_LOWERCASE_LETTER;
import static br.com.itau.password.api.enums.PasswordRuleEnum.AT_LEAST_ONE_SPECIAL_CHARACTER;
import static br.com.itau.password.api.enums.PasswordRuleEnum.AT_LEAST_ONE_UPPERCASE_LETTER;
import static br.com.itau.password.api.enums.PasswordRuleEnum.HAVE_NON_REPEATING_CHARACTERS;
import static br.com.itau.password.api.enums.PasswordRuleEnum.HAVE_NON_SPACES;

@Service
public class PasswordService {

    public boolean isValid(String password){
        var streamPasswordRules = Stream.of(AT_LEAST_ONE_UPPERCASE_LETTER.getRule(),
                                                               AT_LEAST_ONE_LOWERCASE_LETTER.getRule(),
                                                               AT_LEAST_NINE_CHARACTERS.getRule(),
                                                               AT_LEAST_ONE_SPECIAL_CHARACTER.getRule(),
                                                               HAVE_NON_REPEATING_CHARACTERS.getRule(),
                                                               HAVE_NON_SPACES.getRule());

        return streamPasswordRules.allMatch(passwordRule -> passwordRule.validate(password));
    }
}
