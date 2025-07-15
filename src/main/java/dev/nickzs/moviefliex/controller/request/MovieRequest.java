package dev.nickzs.moviefliex.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest(
        @Schema(description = "Title of the movie", example = "The Matrix")
        @NotEmpty(message = "Movie name cannot be empty")
        String title,

        @Schema(description = "Synopsis or a brief description of the movie", example = "A computer hacker learns from mysterious rebels about the true nature of his reality.")
        String description,

        @Schema(description = "Release date of the movie", example = "1999-03-31")
        LocalDate releaseDate,

        @Schema(description = "Movie rating, for example on a scale of 0 to 10", example = "8.7")
        double rating,

        @Schema(description = "List of category IDs to associate with the movie", example = "[1, 5]")
        List<Long> categories,

        @Schema(description = "List of streaming platform IDs where the movie is available", example = "[2, 3]")
        List<Long> streamings
) {
}