package br.com.itau.password.api.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HasNoSpaces implements PasswordRule{

    /**
     * O método verificar se a senha não possue espaços
     * @param password
     * representa a senha do usuario
     * @return true se a senha não contiver espaços
     */
    @Override
    public boolean validate(String password) {
        final String HasNoSpacesRegex = "(\\S+)(?![^\\s])";
        var isValid = password.matches(HasNoSpacesRegex);

        if(!isValid){
            log.info("A senha possue um ou mais espaços em branco");
        }

        return isValid;
    }
}
