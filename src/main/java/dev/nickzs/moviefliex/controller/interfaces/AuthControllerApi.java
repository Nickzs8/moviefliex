package dev.nickzs.moviefliex.controller.interfaces;

import dev.nickzs.moviefliex.controller.request.LoginRequest;
import dev.nickzs.moviefliex.controller.request.UserRequest;
import dev.nickzs.moviefliex.controller.response.LoginResponse;
import dev.nickzs.moviefliex.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Authentication", description = "Resource for user authentication and registration")
public interface AuthControllerApi {

    @Operation(summary = "Register a new user", description = "Endpoint for new user registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully registered",
                    content = @Content(schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content)
    })
    ResponseEntity<UserResponse> register(@RequestBody UserRequest request);

    @Operation(summary = "Authenticate a user", description = "Performs user login and returns a JWT token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful, token returned",
                    content = @Content(schema = @Schema(implementation = LoginResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid username or password", content = @Content)
    })
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request);
}