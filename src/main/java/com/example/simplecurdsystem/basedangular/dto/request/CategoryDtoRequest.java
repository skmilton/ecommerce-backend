package com.example.simplecurdsystem.basedangular.dto.request;

import com.example.simplecurdsystem.basedangular.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDtoRequest {

    private String categoryName;
    private List<Product> products;
}
