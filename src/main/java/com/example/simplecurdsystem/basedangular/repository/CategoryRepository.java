package com.example.simplecurdsystem.basedangular.repository;


import com.example.simplecurdsystem.basedangular.domain.Category;
import com.example.simplecurdsystem.basedangular.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository <Category,String>{
    Optional<Category> findAllById(String id);
   // Optional<Category> findCategoryByProductsAndCategoryName(Product product,Category category);
}
