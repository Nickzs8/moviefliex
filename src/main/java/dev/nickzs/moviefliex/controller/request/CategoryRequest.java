package dev.nickzs.moviefliex.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record CategoryRequest(
        @Schema(description = "Name of the category", example = "Action")
        @NotEmpty(message = "Category name cannot be empty")
        String name
) {
}