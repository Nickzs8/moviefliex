package dev.nickzs.moviefliex.controller.request;

import lombok.Builder;

@Builder
public record CategoryRequest(String name) {
}
