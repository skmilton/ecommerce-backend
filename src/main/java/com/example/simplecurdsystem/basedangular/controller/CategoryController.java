package com.example.simplecurdsystem.basedangular.controller;

import com.example.simplecurdsystem.basedangular.dto.request.CategoryDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.dto.response.CategoryDtoResponse;
import com.example.simplecurdsystem.basedangular.servises.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@AllArgsConstructor
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IdentificationResponse> createCategory(

            @RequestBody @Valid CategoryDtoRequest categoryDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return new ResponseEntity(categoryService.createCategory(categoryDtoRequest), HttpStatus.CREATED);
    }



    @GetMapping("/get-all-category")
    public ResponseEntity<CategoryDtoResponse> getAllCategory() {

        return new ResponseEntity(categoryService.getAllCategorys(), HttpStatus.OK);
    }

    @GetMapping("/get-category-by-id/{id}")
    public ResponseEntity<CategoryDtoResponse> getAllCategoryById(@PathVariable String id) {

        return new ResponseEntity(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PutMapping("/update-category/{id}")
    public void updateCategoryList(@RequestBody CategoryDtoRequest categoryDtoRequest,@PathVariable String id) {
        categoryService.updateCategory(categoryDtoRequest,id);
    }

    @DeleteMapping("/delete/categoryList/by/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }
}
