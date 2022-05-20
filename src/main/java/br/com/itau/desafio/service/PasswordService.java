package br.com.itau.desafio.service;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

import static br.com.itau.desafio.enums.PasswordRuleEnum.AT_LEAST_NINE_CHARACTERS;
import static br.com.itau.desafio.enums.PasswordRuleEnum.AT_LEAST_ONE_LOWERCASE_LETTER;
import static br.com.itau.desafio.enums.PasswordRuleEnum.AT_LEAST_ONE_SPECIAL_CHARACTER;
import static br.com.itau.desafio.enums.PasswordRuleEnum.AT_LEAST_ONE_UPPERCASE_LETTER;
import static br.com.itau.desafio.enums.PasswordRuleEnum.HAVE_NON_REPEATING_CHARACTERS;
import static br.com.itau.desafio.enums.PasswordRuleEnum.HAVE_NON_SPACES;

@Service
public class PasswordService {

    public boolean isValid(String password){
        var streamPasswordRules = Stream.of(AT_LEAST_ONE_UPPERCASE_LETTER.getPasswordRule(),
                                                               AT_LEAST_ONE_LOWERCASE_LETTER.getPasswordRule(),
                                                               AT_LEAST_NINE_CHARACTERS.getPasswordRule(),
                                                               AT_LEAST_ONE_SPECIAL_CHARACTER.getPasswordRule(),
                                                               HAVE_NON_REPEATING_CHARACTERS.getPasswordRule(),
                                                               HAVE_NON_SPACES.getPasswordRule());

        return streamPasswordRules.allMatch(passwordRule -> passwordRule.validate(password));
    }
}
