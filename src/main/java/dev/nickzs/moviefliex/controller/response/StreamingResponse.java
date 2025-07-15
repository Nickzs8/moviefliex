package dev.nickzs.moviefliex.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingResponse(
        @Schema(description = "Unique identifier for the streaming platform", example = "1")
        Long id,

        @Schema(description = "Name of the streaming platform", example = "Netflix")
        String name
) {
}