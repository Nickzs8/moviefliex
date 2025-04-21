package dev.nickzs.moviefliex.service;

import dev.nickzs.moviefliex.entity.Category;
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

    public Optional<Streaming> update(Long id, Streaming updatedstreaming){
        Optional<Streaming> optstreaming = repository.findById(id);

        if(optstreaming.isPresent()){


            Streaming streaming = optstreaming.get();

            streaming.setName(updatedstreaming.getName());

            repository.save(streaming);

            return Optional.of(streaming);
        }

        return Optional.empty();
    }
}
