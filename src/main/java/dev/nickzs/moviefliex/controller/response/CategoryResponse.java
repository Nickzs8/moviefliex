package dev.nickzs.moviefliex.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CategoryResponse(
        @Schema(description = "Unique identifier for the category", example = "1")
        Long id,

        @Schema(description = "Name of the category", example = "Action")
        String name
) {
}