package com.example.simplecurdsystem.basedangular.servises.serviceImpl;
import com.example.simplecurdsystem.basedangular.domain.Category;
import com.example.simplecurdsystem.basedangular.dto.request.CategoryDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.CategoryDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.repository.CategoryRepository;
import com.example.simplecurdsystem.basedangular.servises.CategoryService;
import com.example.simplecurdsystem.basedangular.util.UuidUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createCategory(CategoryDtoRequest categoryDtoRequest) {
        String id = uuidUtil.getUuidUtil();
        Category category = new Category();
        category.setId(id);
        BeanUtils.copyProperties(categoryDtoRequest, category);
        categoryRepository.saveAndFlush(category);
        return new IdentificationResponse(id);
    }

    @Override
    public List<CategoryDtoResponse> getAllCategorys() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDtoResponse> list = new ArrayList<>();
        for(Category response : categoryList){
            CategoryDtoResponse categoryDtoResponse = new CategoryDtoResponse();
            BeanUtils.copyProperties(response, categoryDtoResponse);
            list.add(categoryDtoResponse);
        }
        return list;
    }

    @Override
    public CategoryDtoResponse getCategoryById(String id) {
        Optional<Category> getCategory = categoryRepository.findAllById(id);
        if(!getCategory.isPresent()){
            throw new RuntimeException("Category Not Found");
        }
        Category category = getCategory.get();

        CategoryDtoResponse response = new CategoryDtoResponse();

        //response.setId(category.getId());
        BeanUtils.copyProperties(category, response);

        return response;
    }

    @Override
    public void updateCategory(CategoryDtoRequest categoryDtoRequest, String id){
        Optional<Category> categoryOptional = categoryRepository.findAllById(id);

        if (!categoryOptional.isPresent()){
            throw new RuntimeException("Category Not Found");
        }

        Category category = categoryOptional.get();

        category.setCategoryName(categoryDtoRequest.getCategoryName());
        category.setProducts(categoryDtoRequest.getProducts());
        categoryRepository.save(category);

    }


    public void deleteCategory(String id)   {
        Optional<Category> categoryOptional = categoryRepository.findAllById(id);

        if (!categoryOptional.isPresent()){
            throw new RuntimeException("Category Not Found");
        }
        Category category = categoryOptional.get();

        categoryRepository.delete(category);

    }
}
