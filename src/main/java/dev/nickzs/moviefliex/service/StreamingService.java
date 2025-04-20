package dev.nickzs.moviefliex.service;

import dev.nickzs.moviefliex.entity.Streaming;
import dev.nickzs.moviefliex.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public List<Streaming> findAll(){
        return repository.findAll();
    }

    public Streaming save(Streaming streaming) {
        return repository.save(streaming);
    }

    public Optional<Streaming> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }
}
