package dev.nickzs.moviefliex.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        @Schema(description = "Unique identifier for the movie", example = "1")
        Long id,

        @Schema(description = "Title of the movie", example = "The Matrix")
        String title,

        @Schema(description = "Synopsis of the movie", example = "A computer hacker learns from mysterious rebels about the true nature of his reality.")
        String description,

        @Schema(description = "Release date of the movie", example = "1999-03-31")
        LocalDate releaseDate,

        @Schema(description = "Movie rating on a scale of 0 to 10", example = "8.7")
        double rating,

        @Schema(description = "List of categories associated with the movie")
        List<CategoryResponse> categories,

        @Schema(description = "List of streaming platforms where the movie is available")
        List<StreamingResponse> streamings
) {
}