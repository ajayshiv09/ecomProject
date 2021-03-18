package com.example.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}