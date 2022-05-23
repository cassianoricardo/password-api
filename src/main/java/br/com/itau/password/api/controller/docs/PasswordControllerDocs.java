package br.com.itau.password.api.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;

public interface PasswordControllerDocs {

    @Operation(summary = "Valida as senhas informadas",
            description = "retorna true caso a senha seja valida, caso contrário retorna false")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(array = @ArraySchema(schema = @Schema(
                            implementation = Boolean.class)))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(array = @ArraySchema(schema = @Schema(
                            implementation = HttpStatus.class))))
            })
    boolean isValid(@RequestBody(content = @Content(schema = @Schema(
            implementation = Boolean.class))) String password);
}
