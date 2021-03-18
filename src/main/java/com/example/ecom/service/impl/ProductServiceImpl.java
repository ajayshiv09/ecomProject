package com.example.ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ecom.model.Product;
import com.example.ecom.model.Size;
import com.example.ecom.repository.ProductRepository;
import com.example.ecom.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProductById(Integer productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getByProductCategory(category);
	}

	@Override
	public List<Product> getAllProductsBySize(Size size) {
		return productRepository.getBySize(size.name());
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product editProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

}
