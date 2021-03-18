package com.example.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.model.Seller;

public interface SellerRepository  extends JpaRepository<Seller, Integer>{

}
