package com.example.simplecurdsystem.basedangular.dto.request;

import com.example.simplecurdsystem.basedangular.domain.Category;
import com.example.simplecurdsystem.basedangular.domain.Product;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoRequest {

    private String productName;

    private String code;

    private String qty;

    private String description;

    private String unitPrice;

    private String unitInStock;
    private  String imageUrl;
    private Category category;


}
