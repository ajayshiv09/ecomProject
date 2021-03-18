package com.example.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.model.Order;

public interface OrderRepository  extends JpaRepository<Order, Integer>{

}
