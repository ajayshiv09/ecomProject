package com.example.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
