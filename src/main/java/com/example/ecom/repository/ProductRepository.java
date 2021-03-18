package com.example.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> getByProductCategory(String productCategory);
	List<Product> getBySize(String size);
}
