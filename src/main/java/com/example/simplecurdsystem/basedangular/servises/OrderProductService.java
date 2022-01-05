package com.example.simplecurdsystem.basedangular.servises;

import com.example.simplecurdsystem.basedangular.dto.request.OrderProductDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.dto.response.OrderProductDtoResponse;

import java.util.List;

public interface OrderProductService {
    IdentificationResponse createOrderProduct(OrderProductDtoRequest orderProductDtoRequest);

    List<OrderProductDtoResponse> getAllOrderProducts();

    OrderProductDtoResponse getOrderProductById(String id);

    void updateOrderProduct(OrderProductDtoRequest orderProductDtoRequest, String id);

    void deleteOrderProduct(String id);
}
