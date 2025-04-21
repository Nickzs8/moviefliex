package dev.nickzs.moviefliex.repository;

import dev.nickzs.moviefliex.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
