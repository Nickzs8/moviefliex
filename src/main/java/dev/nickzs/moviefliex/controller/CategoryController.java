package dev.nickzs.moviefliex.controller;

import dev.nickzs.moviefliex.entity.Category;
import dev.nickzs.moviefliex.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviefliex/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping()
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        categoryService.deleteById(id);
        return;
    }
}
