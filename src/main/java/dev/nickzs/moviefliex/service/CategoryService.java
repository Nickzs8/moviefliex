package dev.nickzs.moviefliex.service;

import dev.nickzs.moviefliex.entity.Category;
import dev.nickzs.moviefliex.entity.Movie;
import dev.nickzs.moviefliex.entity.Streaming;
import dev.nickzs.moviefliex.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public Optional<Category> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }

    public Optional<Category> update(Long id, Category updatedCategory){
        Optional<Category> optCategory = repository.findById(id);

        if(optCategory.isPresent()){
            

            Category category = optCategory.get();

            category.setName(updatedCategory.getName());

            repository.save(category);

            return Optional.of(category);
        }

        return Optional.empty();
    }
}
