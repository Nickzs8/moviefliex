package dev.nickzs.moviefliex.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotEmpty(message = "Streaming name cannot be empty") String name) {
}
