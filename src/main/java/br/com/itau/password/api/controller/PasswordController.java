package br.com.itau.password.api.controller;

import br.com.itau.password.api.controller.docs.PasswordControllerDocs;
import br.com.itau.password.api.dto.PasswordDTO;
import br.com.itau.password.api.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.itau.password.api.util.Constantes.PATH_IS_VALID;
import static br.com.itau.password.api.util.Constantes.PATH_PASSWORD;

@RestController
@RequestMapping(PATH_PASSWORD)
@AllArgsConstructor
public class PasswordController implements PasswordControllerDocs {

    private PasswordService passwordService;

    @PostMapping(PATH_IS_VALID)
    public boolean isValid(@RequestBody PasswordDTO passwordDTO) {
        return passwordService.isValid(passwordDTO);
    }
}

