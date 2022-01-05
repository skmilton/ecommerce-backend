package com.example.simplecurdsystem.basedangular.controller;

import com.example.simplecurdsystem.basedangular.dto.request.OrderDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.OrderDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.servises.OrderService;
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
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createOrder(

            @RequestBody @Valid OrderDtoRequest orderDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return new ResponseEntity(orderService.createOrder(orderDtoRequest), HttpStatus.CREATED);
    }



    @GetMapping("/get-all-order")
    public ResponseEntity<OrderDtoResponse> getAllOrder() {

        return new ResponseEntity(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/get-order-by-id/{id}")
    public ResponseEntity<OrderDtoResponse> getAllOrderById(@PathVariable String id) {

        return new ResponseEntity(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PutMapping("/update-order/{id}")
    public void updateOrderList(@RequestBody OrderDtoRequest orderDtoRequest,@PathVariable String id) {
        orderService.updateOrder(orderDtoRequest,id);
    }

    @DeleteMapping("/delete/orderList/by/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
    }
}
