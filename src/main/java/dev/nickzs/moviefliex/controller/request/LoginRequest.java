package dev.nickzs.moviefliex.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(
        @Schema(description = "User's email address", example = "user@example.com")
        String email,

        @Schema(description = "User's password", example = "password123", format = "password")
        String password
) {
}