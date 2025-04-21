package dev.nickzs.moviefliex.repository;

import dev.nickzs.moviefliex.entity.Category;
import dev.nickzs.moviefliex.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(List<Category> categories);
}
