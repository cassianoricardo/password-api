package br.com.itau.desafio.controller;

import br.com.itau.desafio.service.PasswordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("password")
public class PasswordController {

    private PasswordService passwordService;

    @GetMapping
    @ApiOperation(value = "isValid", notes = "valida a senha informada")
    private boolean isValid(@RequestParam("password") String password) {

        return passwordService.isValid(password);
    }
}

