package com.example.simplecurdsystem.basedangular.dto.response;

import com.example.simplecurdsystem.basedangular.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoResponse extends IdentificationResponse{

    private String productName;

    private String code;

    private String qty;

    private String description;

    private String unitPrice;

    private String unitInStock;

    private  String imageUrl;
    private Category category;
}
