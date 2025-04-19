package dev.nickzs.moviefliex.service;

import dev.nickzs.moviefliex.entity.Category;
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

    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    public Category findById(long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }
}
