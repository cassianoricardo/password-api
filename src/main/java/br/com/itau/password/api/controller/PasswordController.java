package br.com.itau.password.api.controller;

import br.com.itau.password.api.service.PasswordService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("password")
@AllArgsConstructor
public class PasswordController {

    private PasswordService passwordService;

    @GetMapping
    @ApiOperation(value = "isValid", notes = "Endpoint responsavel por validar a senha")
    private boolean isValid(@RequestParam("password") String password) {
        return passwordService.isValid(password);
    }
}

