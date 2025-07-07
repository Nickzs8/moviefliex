package dev.nickzs.moviefliex.controller;

import dev.nickzs.moviefliex.controller.request.MovieRequest;
import dev.nickzs.moviefliex.controller.response.MovieResponse;
import dev.nickzs.moviefliex.entity.Movie;
import dev.nickzs.moviefliex.mapper.MovieMapper;
import dev.nickzs.moviefliex.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moviefliex/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


    @GetMapping()
    public ResponseEntity<List<MovieResponse>> getAll() {
        List<MovieResponse> movies = movieService.findAll().stream()
                .map(MovieMapper::toMovieResponse)
                .toList();

        return ResponseEntity.ok(movies);
    }


    @PostMapping()
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request) {
        Movie newMovie = MovieMapper.toMovie(request);
        newMovie = movieService.save(newMovie);

        return ResponseEntity.status(HttpStatus.CREATED).body(
               MovieMapper.toMovieResponse(newMovie)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(streaming -> ResponseEntity.ok(MovieMapper.toMovieResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Optional<Movie> optMovie = movieService.findById(id);

        if(optMovie.isPresent()) {
            movieService.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request) {
        return movieService.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long categoryId) {
        List<MovieResponse> movies = movieService.findByCategory(categoryId).stream()
                .map(MovieMapper::toMovieResponse)
                .toList();

        return ResponseEntity.ok(movies);
    }

}
