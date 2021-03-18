package com.example.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.model.OrderTransaction;

public interface OrderTransactionRepository extends JpaRepository<OrderTransaction, Integer> {

}
