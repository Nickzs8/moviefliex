package dev.nickzs.moviefliex.service;

import dev.nickzs.moviefliex.entity.Movie;
import dev.nickzs.moviefliex.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    public Optional<Movie> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }
}
