package com.example.simplecurdsystem.basedangular.servises.serviceImpl;
import com.example.simplecurdsystem.basedangular.domain.Cart;
import com.example.simplecurdsystem.basedangular.domain.EmployeeInformation;
import com.example.simplecurdsystem.basedangular.domain.Order;
import com.example.simplecurdsystem.basedangular.domain.OrderProduct;
import com.example.simplecurdsystem.basedangular.dto.request.CartDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.CartDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.repository.CartRepository;
import com.example.simplecurdsystem.basedangular.servises.CartService;
import com.example.simplecurdsystem.basedangular.util.UuidUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;
    private final UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createCart(CartDtoRequest cartDtoRequest) {
        String id = uuidUtil.getUuidUtil();
        Cart cart = new Cart();
        cart.setId(id);
        BeanUtils.copyProperties(cartDtoRequest, cart);
        cartRepository.saveAndFlush(cart);
        return new IdentificationResponse(id);
    }

    @Override
    public List<CartDtoResponse> getAllCarts() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartDtoResponse> list = new ArrayList<>();
        for(Cart response : cartList){
            CartDtoResponse cartDtoResponse = new CartDtoResponse();
            BeanUtils.copyProperties(response, cartDtoResponse);
            list.add(cartDtoResponse);
        }
        return list;
    }

    @Override
    public CartDtoResponse getCartById(String id) {
        Optional<Cart> getCart = cartRepository.findAllById(id);
        if(!getCart.isPresent()){
            throw new RuntimeException("Cart Not Found");
        }
        Cart cart = getCart.get();

        CartDtoResponse response = new CartDtoResponse();

        response.setId(cart.getId());
        BeanUtils.copyProperties(cart, response);

        return response;
    }

    @Override
    public void updateCart(CartDtoRequest cartDtoRequest, String id){
        Optional<Cart> cartOptional = cartRepository.findAllById(id);

        if (!cartOptional.isPresent()){
            throw new RuntimeException("Cart Not Found");
        }

        Cart cart = cartOptional.get();

            //cart.setProducts(cartDtoRequest.setProducts(EmployeeInformation);
            //cart.setEmployeeInformation(cartDtoRequest.getEmployeeInformation());

//        cart.setCartName(cartDtoRequest.getCartName());
//        cart.setCode(cartDtoRequest.getCode());
//        cart.setQty(cartDtoRequest.getQty());
//        cart.setDescription(cartDtoRequest.getDescription());
//        cart.setUnitPrice(cartDtoRequest.getUnitPrice());
//        cart.setUnitInStock(cartDtoRequest.getUnitInStock());
//        cart.setImageUrl(cartDtoRequest.getImageUrl());
//        cart.setCategory(cartDtoRequest.getCategory());

        cartRepository.save(cart);

    }


    public void deleteCart(String id)   {
        Optional<Cart> cartOptional = cartRepository.findAllById(id);

        if (!cartOptional.isPresent()){
            throw new RuntimeException("Cart Not Found");
        }
        Cart cart = cartOptional.get();

        cartRepository.delete(cart);

    }
}
