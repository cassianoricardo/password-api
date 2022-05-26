package br.com.itau.password.api.controller;

import br.com.itau.password.api.SpringTest;
import br.com.itau.password.api.dto.PasswordDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static br.com.itau.password.api.util.Constantes.PATH_IS_VALID;
import static br.com.itau.password.api.util.Constantes.PATH_PASSWORD;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PasswordApiIntegrationTest extends SpringTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    static Stream<Arguments> passwordsAndExpectedOutputFailProvider() {
        return Stream.of(
                arguments("", false),
                arguments("aa", false),
                arguments("ab#", false),
                arguments("AAAbbbCc*", false),
                arguments("AbTp9!foo", false),
                arguments("AbTp9!foA", false),
                arguments("AbTp9 fok", false)
        );
    }

    static Stream<Arguments> passwordsAndExpectedOutputSuccessProvider() {
        return Stream.of(
                arguments("AbTp9!fok", true)
        );
    }


    @MethodSource("passwordsAndExpectedOutputFailProvider")
    @ParameterizedTest(name = "Verifica se a senha: \"{0}\" é inválida")
    public void invalidPassword(String password, boolean outputExpected) throws Exception {
        final String stringJson = mapper.writeValueAsString(PasswordDTO.builder().password(password).build());

        mockMvc.perform(post(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .content(asJsonString(PasswordDTO.builder().password(password).build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(outputExpected)));
    }


    @MethodSource("passwordsAndExpectedOutputSuccessProvider")
    @ParameterizedTest(name = "Verifica se a senha: \"{0}\" é válida")
    public void validPassword(String password, boolean outputExpected) throws Exception {
        final String stringJson = mapper.writeValueAsString(PasswordDTO.builder().password(password).build());

        mockMvc.perform(post(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .content(asJsonString(PasswordDTO.builder().password(password).build()))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(outputExpected)));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}