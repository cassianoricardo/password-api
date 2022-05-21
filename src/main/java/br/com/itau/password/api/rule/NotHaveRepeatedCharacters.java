package br.com.itau.password.api.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotHaveRepeatedCharacters implements PasswordRule {

    /**
     * O método verificar se a senha contem algum caracter repetido
     * @param password
     * representa a senha do usuario
     * @return true se a senha possuir algum caracter repetido
     */
    @Override
    public boolean validate(String password) {
        final var notContainsRepeatCharacterRegex = "(?!.*(.).*\\1).*";

        var isValid = password.matches(notContainsRepeatCharacterRegex);

        if(!isValid){
            log.info("A senha possue um ou mais caracteres repetidos");
        }

        return isValid;
    }
}
