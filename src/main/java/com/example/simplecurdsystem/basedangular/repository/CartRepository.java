package com.example.simplecurdsystem.basedangular.repository;

import com.example.simplecurdsystem.basedangular.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, String>{
    Optional<Cart> findAllById(String id);
}
