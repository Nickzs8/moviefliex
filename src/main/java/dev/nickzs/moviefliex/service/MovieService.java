package dev.nickzs.moviefliex.service;

import dev.nickzs.moviefliex.entity.Category;
import dev.nickzs.moviefliex.entity.Movie;
import dev.nickzs.moviefliex.entity.Streaming;
import dev.nickzs.moviefliex.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));

        return repository.save(movie);
    }

    public Optional<Movie> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }

    public Optional<Movie> update(Long id, Movie updatedMovie){
        Optional<Movie> optMovie = repository.findById(id);

        if(optMovie.isPresent()){

            List<Category> categories = this.findCategories(updatedMovie.getCategories());
            List<Streaming> streamings = this.findStreamings(updatedMovie.getStreamings());

            Movie movie = optMovie.get();

            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(updatedMovie.getDescription());
            movie.setReleaseDate(updatedMovie.getReleaseDate());
            movie.setRating(updatedMovie.getRating());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            repository.save(movie);

            return Optional.of(movie);
        }

        return Optional.empty();
    }

    public List<Movie> findByCategory(Long categoryId){
        return repository.findMovieByCategories(List.of(Category.builder().
                id(categoryId).
                build())
        );
    }

    private List<Category> findCategories(List<Category> categories){
        List<Category> categoriesFound = new ArrayList<>();

        categories.forEach(category -> {
            categoryService.findById(category.getId()).ifPresent(categoriesFound::add);
        });

        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> categories) {
        List<Streaming> streamingsFound = new ArrayList<>();

        categories.forEach(streaming -> {
            streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add);
        });

        return streamingsFound;
    }
}
