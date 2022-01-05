package com.example.simplecurdsystem.basedangular.dto.response;

import com.example.simplecurdsystem.basedangular.domain.Order;
import com.example.simplecurdsystem.basedangular.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDtoResponse {
    private String id;
    private Product product;
    private Order order;
    private Integer qty;
}
