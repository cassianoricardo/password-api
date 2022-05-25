package br.com.itau.password.api.integration;

import br.com.itau.password.api.SpringTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.Stream;

import static br.com.itau.password.api.util.Constantes.PASSWORD;
import static br.com.itau.password.api.util.Constantes.PATH_IS_VALID;
import static br.com.itau.password.api.util.Constantes.PATH_PASSWORD;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PasswordApiIntegrationTest extends SpringTest {

    @Autowired
    private MockMvc mockMvc;

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
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, password)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(outputExpected)));
    }


    @MethodSource("passwordsAndExpectedOutputSuccessProvider")
    @ParameterizedTest(name = "Verifica se a senha: \"{0}\" é válida")
    public void validPassword(String password, boolean outputExpected) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH_PASSWORD.concat(PATH_IS_VALID))
                        .queryParam(PASSWORD, password)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(outputExpected)));
    }

}