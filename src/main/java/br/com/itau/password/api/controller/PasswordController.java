package br.com.itau.password.api.controller;

import br.com.itau.password.api.controller.docs.PasswordControllerDocs;
import br.com.itau.password.api.app.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import static br.com.itau.password.api.util.Constantes.PASSWORD;
import static br.com.itau.password.api.util.Constantes.PATH_IS_VALID;
import static br.com.itau.password.api.util.Constantes.PATH_PASSWORD;

@RestController
@RequestMapping(PATH_PASSWORD)
@AllArgsConstructor
public class PasswordController implements PasswordControllerDocs {

    private PasswordService passwordService;

    @GetMapping(PATH_IS_VALID)
    public boolean isValid(@PathParam(PASSWORD) String password) {
        return passwordService.isValid(password);
    }
}

