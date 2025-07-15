package dev.nickzs.moviefliex.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserRequest(
        @Schema(description = "User's full name", example = "John Doe")
        String name,

        @Schema(description = "User's email address for login", example = "john.doe@example.com")
        String email,

        @Schema(description = "User's password", example = "strongPassword123", format = "password")
        String password
) {
}