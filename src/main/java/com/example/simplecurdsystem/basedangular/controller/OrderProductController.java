package com.example.simplecurdsystem.basedangular.controller;

import com.example.simplecurdsystem.basedangular.dto.request.OrderProductDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.OrderProductDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.servises.OrderProductService;
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
@RequestMapping("/orderProduct")
@CrossOrigin(origins = "*")
public class OrderProductController {
    private final OrderProductService orderProductService;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createOrderProduct(

            @RequestBody @Valid OrderProductDtoRequest orderProductDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return new ResponseEntity(orderProductService.createOrderProduct(orderProductDtoRequest), HttpStatus.CREATED);
    }



    @GetMapping("/get-all-orderProduct")
    public ResponseEntity<OrderProductDtoResponse> getAllOrderProduct() {

        return new ResponseEntity(orderProductService.getAllOrderProducts(), HttpStatus.OK);
    }

    @GetMapping("/get-orderProduct-by-id/{id}")
    public ResponseEntity<OrderProductDtoResponse> getAllOrderProductById(@PathVariable String id) {

        return new ResponseEntity(orderProductService.getOrderProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update-orderProduct/{id}")
    public void updateOrderProductList(@RequestBody OrderProductDtoRequest orderProductDtoRequest,@PathVariable String id) {
        orderProductService.updateOrderProduct(orderProductDtoRequest,id);
    }

    @DeleteMapping("/delete/orderProductList/by/{id}")
    public void deleteOrderProduct(@PathVariable String id) {
        orderProductService.deleteOrderProduct(id);
    }
}
