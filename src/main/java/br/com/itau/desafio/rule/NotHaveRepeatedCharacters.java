package br.com.itau.desafio.rule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
            log.info("A senha possue um ou mais espaços em branco");
        }

        return isValid;
    }
}
