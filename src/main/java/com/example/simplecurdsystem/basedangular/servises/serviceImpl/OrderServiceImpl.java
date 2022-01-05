package com.example.simplecurdsystem.basedangular.servises.serviceImpl;

import com.example.simplecurdsystem.basedangular.domain.Order;
import com.example.simplecurdsystem.basedangular.dto.request.OrderDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.OrderDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.repository.OrderRepository;
import com.example.simplecurdsystem.basedangular.servises.OrderService;
import com.example.simplecurdsystem.basedangular.util.UuidUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createOrder(OrderDtoRequest orderDtoRequest) {
        String id = uuidUtil.getUuidUtil();
        Order order = new Order();
        order.setId(id);
        BeanUtils.copyProperties(orderDtoRequest, order);
        orderRepository.saveAndFlush(order);
        return new IdentificationResponse(id);
    }

    @Override
    public List<OrderDtoResponse> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDtoResponse> list = new ArrayList<>();
        for(Order response : orderList){
            OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
            BeanUtils.copyProperties(response, orderDtoResponse);
            list.add(orderDtoResponse);
        }
        return list;
    }

    @Override
    public OrderDtoResponse getOrderById(String id) {
        Optional<Order> getOrder = orderRepository.findAllById(id);
        if(!getOrder.isPresent()){
            throw new RuntimeException("Order Not Found");
        }
        Order order = getOrder.get();

        OrderDtoResponse response = new OrderDtoResponse();

        response.setId(order.getId());
        BeanUtils.copyProperties(order, response);

        return response;
    }

    @Override
    public void updateOrder(OrderDtoRequest orderDtoRequest, String id){
        Optional<Order> orderOptional = orderRepository.findAllById(id);

        if (!orderOptional.isPresent()){
            throw new RuntimeException("Order Not Found");
        }

        Order order = orderOptional.get();

        //order.setProducts(orderDtoRequest.setProducts(EmployeeInformation);
        //order.setEmployeeInformation(orderDtoRequest.getEmployeeInformation());

//        order.setOrderName(orderDtoRequest.getOrderName());
//        order.setCode(orderDtoRequest.getCode());
//        order.setQty(orderDtoRequest.getQty());
//        order.setDescription(orderDtoRequest.getDescription());
//        order.setUnitPrice(orderDtoRequest.getUnitPrice());
//        order.setUnitInStock(orderDtoRequest.getUnitInStock());
//        order.setImageUrl(orderDtoRequest.getImageUrl());
//        order.setCategory(orderDtoRequest.getCategory());

        orderRepository.save(order);

    }


    public void deleteOrder(String id)   {
        Optional<Order> orderOptional = orderRepository.findAllById(id);

        if (!orderOptional.isPresent()){
            throw new RuntimeException("Order Not Found");
        }
        Order order = orderOptional.get();

        orderRepository.delete(order);

    }
}
