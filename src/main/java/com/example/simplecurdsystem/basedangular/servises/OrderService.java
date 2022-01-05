package com.example.simplecurdsystem.basedangular.servises;

import com.example.simplecurdsystem.basedangular.dto.request.OrderDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.dto.response.OrderDtoResponse;

import java.util.List;

public interface OrderService {
    IdentificationResponse createOrder(OrderDtoRequest orderDtoRequest);

    List<OrderDtoResponse> getAllOrders();

    OrderDtoResponse getOrderById(String id);

    void updateOrder(OrderDtoRequest orderDtoRequest, String id);

    void deleteOrder(String id);
    
}
