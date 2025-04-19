package dev.nickzs.moviefliex.mapper;

import dev.nickzs.moviefliex.controller.request.CategoryRequest;
import dev.nickzs.moviefliex.controller.response.CategoryResponse;
import dev.nickzs.moviefliex.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
