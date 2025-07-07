package dev.nickzs.moviefliex.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest(@NotEmpty(message = "Movie name cannot be empty") String title,
                           String description,
                           LocalDate releaseDate,
                           double rating,
                           List<Long> categories,
                           List<Long> streamings){
}
