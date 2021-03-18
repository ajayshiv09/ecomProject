package com.example.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecom.model.Product;
import com.example.ecom.model.Size;
import com.example.ecom.service.ProductService;

@Controller("/Product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getProductsByCategory/{category}")
	public ResponseEntity<?> getProductsByCategory(@PathVariable(name = "category", required = true) String category) {
		return new ResponseEntity<>(productService.getProductsByCategory(category), HttpStatus.OK);
	}

	@GetMapping("/getProductsBySize/{size}")
	public ResponseEntity<?> getAllProductsBySize(@PathVariable(name = "size", required = true) String size) {
		return new ResponseEntity<>(productService.getAllProductsBySize(Size.valueOf(size)), HttpStatus.OK);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable(name = "productId", required = true) Integer productId) {
		return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(name = "productId", required = true) Integer productId) {
		productService.deleteProduct(null);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/addProducts")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
	}

	@PatchMapping("/editProduct/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.editProduct(product), HttpStatus.OK);
	}

}