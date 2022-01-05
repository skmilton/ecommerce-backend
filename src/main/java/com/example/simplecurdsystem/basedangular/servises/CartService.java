package com.example.simplecurdsystem.basedangular.servises;

import com.example.simplecurdsystem.basedangular.dto.request.CartDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.CartDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;

import java.util.List;

public interface CartService {
    IdentificationResponse createCart(CartDtoRequest cartDtoRequest);

    List<CartDtoResponse> getAllCarts();

    CartDtoResponse getCartById(String id);

    void updateCart(CartDtoRequest cartDtoRequest, String id);

    void deleteCart(String id);
}
