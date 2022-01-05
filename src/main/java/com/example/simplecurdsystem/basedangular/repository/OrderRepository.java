package com.example.simplecurdsystem.basedangular.repository;

import com.example.simplecurdsystem.basedangular.domain.Cart;
import com.example.simplecurdsystem.basedangular.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    Optional<Order> findAllById(String id);
}
