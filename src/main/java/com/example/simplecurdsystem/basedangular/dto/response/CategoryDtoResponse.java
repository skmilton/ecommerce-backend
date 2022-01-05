package com.example.simplecurdsystem.basedangular.dto.response;

import com.example.simplecurdsystem.basedangular.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDtoResponse {

    private String id;
    private String categoryName;
    private List<Product> products;
}
