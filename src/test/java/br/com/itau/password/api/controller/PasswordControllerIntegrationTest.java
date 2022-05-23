package br.com.itau.password.api.controller;

import br.com.itau.password.api.SpringBootIntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static br.com.itau.password.api.util.Constantes.PASSWORD;
import static br.com.itau.password.api.util.Constantes.PATH_IS_VALID;
import static br.com.itau.password.api.util.Constantes.PATH_PASSWORD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PasswordControllerIntegrationTest extends SpringBootIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Verifica se a senha passou por todas as regras de validacao")
    public void validPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, "Senha123*")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("Verifica se a senha está sendo reprovada por não conter ao menos nove caracteres")
    public void passwordLessThanNineCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, "Senha12*")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    @DisplayName("Verifica se a senha está sendo reprovada por não conter ao menos uma letra maiuscula")
    public void passwordWithoutUpperLetter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, "senha123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    @DisplayName("Verifica se a senha está sendo reprovada por não conter ao menos uma letra minuscula")
    public void passwordWithoutLowerLetter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, "SENHA123*")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    @DisplayName("Verifica se a senha está sendo reprovada por conter espaços em branco")
    public void passwordWithWhiteSpace() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, "Senha123 *")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    @DisplayName("Verifica se a senha está sendo reprovada por conter caracteres repetidos")
    public void passwordWithRepeatedCharacter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, "Password1*")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    @DisplayName("Verifica se a senha está sendo reprovada por não conter ao menos um dos caracteres: ! @ # $ % ^ & * ( ) - +")
    public void passwordWithoutSpecialCharacter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, "Password1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

}