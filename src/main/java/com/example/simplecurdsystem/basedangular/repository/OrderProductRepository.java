package com.example.simplecurdsystem.basedangular.repository;

import com.example.simplecurdsystem.basedangular.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct,String> {
    Optional<OrderProduct> findAllById(String id);
}
