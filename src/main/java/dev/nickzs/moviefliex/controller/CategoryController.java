package dev.nickzs.moviefliex.controller;

import dev.nickzs.moviefliex.controller.request.CategoryRequest;
import dev.nickzs.moviefliex.controller.response.CategoryResponse;
import dev.nickzs.moviefliex.entity.Category;
import dev.nickzs.moviefliex.mapper.CategoryMapper;
import dev.nickzs.moviefliex.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviefliex/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.findAll().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }


    @PostMapping()
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);
        newCategory = categoryService.save(newCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                CategoryMapper.toCategoryResponse(newCategory)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
