package com.example.simplecurdsystem.basedangular.servises.serviceImpl;

import com.example.simplecurdsystem.basedangular.domain.OrderProduct;
import com.example.simplecurdsystem.basedangular.dto.request.OrderProductDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.request.OrderProductDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.OrderProductDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.dto.response.OrderProductDtoResponse;
import com.example.simplecurdsystem.basedangular.repository.OrderProductRepository;
import com.example.simplecurdsystem.basedangular.servises.OrderProductService;
import com.example.simplecurdsystem.basedangular.util.UuidUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class OrderProductServiceImpl implements OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createOrderProduct(OrderProductDtoRequest orderProductDtoRequest) {
        String id = uuidUtil.getUuidUtil();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(id);
        BeanUtils.copyProperties(orderProductDtoRequest, orderProduct);
        orderProductRepository.saveAndFlush(orderProduct);
        return new IdentificationResponse(id);
    }

    @Override
    public List<OrderProductDtoResponse> getAllOrderProducts() {
        List<OrderProduct> orderProductList = orderProductRepository.findAll();
        List<OrderProductDtoResponse> list = new ArrayList<>();
        for(OrderProduct response : orderProductList){
            OrderProductDtoResponse orderProductDtoResponse = new OrderProductDtoResponse();
            BeanUtils.copyProperties(response, orderProductDtoResponse);
            list.add(orderProductDtoResponse);
        }
        return list;
    }

    @Override
    public OrderProductDtoResponse getOrderProductById(String id) {
        Optional<OrderProduct> getOrderProduct = orderProductRepository.findAllById(id);
        if(!getOrderProduct.isPresent()){
            throw new RuntimeException("OrderProduct Not Found");
        }
        OrderProduct orderProduct = getOrderProduct.get();

        OrderProductDtoResponse response = new OrderProductDtoResponse();

        response.setId(orderProduct.getId());
        BeanUtils.copyProperties(orderProduct, response);

        return response;
    }

    @Override
    public void updateOrderProduct(OrderProductDtoRequest orderProductDtoRequest, String id){
        Optional<OrderProduct> orderProductOptional = orderProductRepository.findAllById(id);

        if (!orderProductOptional.isPresent()){
            throw new RuntimeException("OrderProduct Not Found");
        }

        OrderProduct orderProduct = orderProductOptional.get();

        //orderProduct.setProducts(orderProductDtoRequest.setProducts(EmployeeInformation);
        //orderProduct.setEmployeeInformation(orderProductDtoRequest.getEmployeeInformation());

//        orderProduct.setOrderProductName(orderProductDtoRequest.getOrderProductName());
//        orderProduct.setCode(orderProductDtoRequest.getCode());
//        orderProduct.setQty(orderProductDtoRequest.getQty());
//        orderProduct.setDescription(orderProductDtoRequest.getDescription());
//        orderProduct.setUnitPrice(orderProductDtoRequest.getUnitPrice());
//        orderProduct.setUnitInStock(orderProductDtoRequest.getUnitInStock());
//        orderProduct.setImageUrl(orderProductDtoRequest.getImageUrl());
//        orderProduct.setCategory(orderProductDtoRequest.getCategory());

        orderProductRepository.save(orderProduct);

    }


    public void deleteOrderProduct(String id)   {
        Optional<OrderProduct> orderProductOptional = orderProductRepository.findAllById(id);

        if (!orderProductOptional.isPresent()){
            throw new RuntimeException("OrderProduct Not Found");
        }
        OrderProduct orderProduct = orderProductOptional.get();

        orderProductRepository.delete(orderProduct);

    }
}
