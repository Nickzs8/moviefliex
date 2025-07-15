package dev.nickzs.moviefliex.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(
        @Schema(description = "Unique identifier for the user", example = "1")
        Long id,

        @Schema(description = "Name of the user", example = "John Doe")
        String name,

        @Schema(description = "Email of the user", example = "john.doe@example.com")
        String email
) {
}