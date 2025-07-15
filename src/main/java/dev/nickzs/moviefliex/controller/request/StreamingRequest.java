package dev.nickzs.moviefliex.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(
        @Schema(description = "Name of the streaming platform", example = "Netflix")
        @NotEmpty(message = "Streaming name cannot be empty")
        String name
) {
}