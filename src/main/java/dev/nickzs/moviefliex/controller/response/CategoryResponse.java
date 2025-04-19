package dev.nickzs.moviefliex.controller.response;

import lombok.Builder;
import lombok.Data;

@Builder
public record CategoryResponse(Long id, String name) {
}
