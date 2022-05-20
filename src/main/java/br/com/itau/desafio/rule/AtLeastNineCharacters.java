package br.com.itau.desafio.rule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AtLeastNineCharacters implements PasswordRule {

    /**
     * O método verificar se a senha possue nove ou mais caracteres
     * @param password
     * representa a senha do usuario
     * @return true se a senha contiver nove ou mais caracteres
     */
    @Override
    public boolean validate(String password) {

        final var containsAtLeastNineCharactersRegex = "(.{9,})";

        var isValid = password.matches(containsAtLeastNineCharactersRegex);

        if(!isValid){
            log.info("A senha não possue ao menos 9 caracteres");
        }

        return isValid;
    }
}