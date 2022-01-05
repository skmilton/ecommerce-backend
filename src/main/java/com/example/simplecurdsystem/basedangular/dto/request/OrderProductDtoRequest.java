package com.example.simplecurdsystem.basedangular.dto.request;

import com.example.simplecurdsystem.basedangular.domain.Order;
import com.example.simplecurdsystem.basedangular.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDtoRequest {

    private Product product;
    private Order order;
    private Integer qty;
}
