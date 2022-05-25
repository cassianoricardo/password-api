package br.com.itau.password.api.app.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AtLeastOneUpperCaseLetterRule implements PasswordRule {

    /**
     * O método verificar se a senha possuir ao menos uma letra maiusculo
     * @param password
     * representa a senha do usuario
     * @return true se a senha possuir ao menos uma letra maiuscula
     */
    @Override
    public boolean validate(String password) {
        final var containsAtLeastOneUpperCaseLetterRegex = "(.*[A-Z].*)";
        var isValid = password.matches(containsAtLeastOneUpperCaseLetterRegex);

        if(!isValid){
            log.info("A senha não possue ao menos uma letra maiuscula");
        }

        return isValid;
    }
}
