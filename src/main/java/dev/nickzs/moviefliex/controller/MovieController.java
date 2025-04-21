package dev.nickzs.moviefliex.controller;

import dev.nickzs.moviefliex.controller.request.MovieRequest;
import dev.nickzs.moviefliex.controller.response.MovieResponse;
import dev.nickzs.moviefliex.entity.Movie;
import dev.nickzs.moviefliex.mapper.MovieMapper;
import dev.nickzs.moviefliex.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        Movie newMovie = MovieMapper.toMovie(request);
        newMovie = movieService.save(newMovie);

        return ResponseEntity.status(HttpStatus.CREATED).body(
               MovieMapper.toMovieResponse(newMovie)
        );
    }

/*    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        streamingService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/
}
