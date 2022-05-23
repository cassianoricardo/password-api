package br.com.itau.password.api.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AtLeastOneLowerCaseLetterRule implements PasswordRule {

    /**
     * o método verificar se a senha possuir ao menos uma letra minuscula
     * @param password
     * representa a senha do usuario
     * @return true se a senha possuir ao menos uma letra minuscula
     */
    @Override
    public boolean validate(String password) {
        final var containsAtLeastOneLowerCaseLetterRegex = "(.*[a-z].*)";

        var isValid = password.matches(containsAtLeastOneLowerCaseLetterRegex);

        if(!isValid){
            log.info("A senha não possue ao menos uma letra minuscula");
        }

        return isValid;
    }
}
