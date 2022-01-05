package com.example.simplecurdsystem.basedangular.controller;

import com.example.simplecurdsystem.basedangular.dto.request.CartDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.dto.response.CartDtoResponse;
import com.example.simplecurdsystem.basedangular.servises.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {
    private final CartService cartService;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createCart(

            @RequestBody @Valid CartDtoRequest cartDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return new ResponseEntity(cartService.createCart(cartDtoRequest), HttpStatus.CREATED);
    }



    @GetMapping("/get-all-cart")
    public ResponseEntity<CartDtoResponse> getAllCart() {

        return new ResponseEntity(cartService.getAllCarts(), HttpStatus.OK);
    }

    @GetMapping("/get-cart-by-id/{id}")
    public ResponseEntity<CartDtoResponse> getAllCartById(@PathVariable String id) {

        return new ResponseEntity(cartService.getCartById(id), HttpStatus.OK);
    }

    @PutMapping("/update-cart/{id}")
    public void updateCartList(@RequestBody CartDtoRequest cartDtoRequest,@PathVariable String id) {
        cartService.updateCart(cartDtoRequest,id);
    }

    @DeleteMapping("/delete/cartList/by/{id}")
    public void deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
    }
}
