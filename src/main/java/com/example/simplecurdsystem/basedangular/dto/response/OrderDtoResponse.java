package com.example.simplecurdsystem.basedangular.dto.response;

import com.example.simplecurdsystem.basedangular.domain.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoResponse {
    private String id;
    private BigDecimal totalPrice;

    private Date date = new Date();

    private Date deliveryDate;

    private int employeeInformation_id;

    List<OrderProduct> products = new ArrayList<>();
}
