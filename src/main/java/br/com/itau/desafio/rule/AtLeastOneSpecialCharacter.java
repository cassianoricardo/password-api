package br.com.itau.desafio.rule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AtLeastOneSpecialCharacter implements PasswordRule {

    /**
     * O método verificar se a senha contem ao menos um caracter especial
     * @param password
     * representa a senha do usuario
     * @return true se a senha possuir um caracter especial
     */
    @Override
    public boolean validate(String password) {
        final var containsAtLeastOneSpecialCharacterRegex = "(.*[!|@|#|$|%|^|&|*|(|)|-|+].*)";

        var isValid = password.matches(containsAtLeastOneSpecialCharacterRegex);

        if(!isValid){
            log.info("A senha não possue ao menos um dos seguintes caracteres: !@#$%^&()-+");
        }

        return isValid;
    }
}
