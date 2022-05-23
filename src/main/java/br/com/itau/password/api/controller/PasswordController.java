package br.com.itau.password.api.controller;

import br.com.itau.password.api.controller.docs.PasswordControllerDocs;
import br.com.itau.password.api.service.PasswordService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import static br.com.itau.password.api.controller.PasswordController.PATH_URL_PREFIX;

@RestController
@RequestMapping(PATH_URL_PREFIX)
@AllArgsConstructor
public class PasswordController implements PasswordControllerDocs {

    public static final String PATH_URL_PREFIX = "/password";
    public static final String IS_VALID = "/isValid";

    private PasswordService passwordService;

    @GetMapping(IS_VALID)
    public boolean isValid(@PathParam("password") String password) {
        return passwordService.isValid(password);
    }
}

