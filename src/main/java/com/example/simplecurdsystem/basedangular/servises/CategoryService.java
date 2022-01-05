package com.example.simplecurdsystem.basedangular.servises;



import com.example.simplecurdsystem.basedangular.dto.request.CategoryDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.dto.response.CategoryDtoResponse;

import java.util.List;

public interface CategoryService {
    IdentificationResponse createCategory(CategoryDtoRequest categoryDtoRequest);

    List<CategoryDtoResponse> getAllCategorys();

    CategoryDtoResponse getCategoryById(String id);

    void updateCategory(CategoryDtoRequest categoryDtoRequest, String id);

    void deleteCategory(String id);
}
