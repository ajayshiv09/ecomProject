package com.example.ecom.service;

import java.util.List;

import com.example.ecom.model.Product;
import com.example.ecom.model.Size;

public interface ProductService {
	Product getProductById(Integer productId);

	List<Product> getProductsByCategory(String category);

	List<Product> getAllProductsBySize(Size size);

	Product editProduct(Product product);

	void deleteProduct(Integer id);

	Product addProduct(Product product);
}

