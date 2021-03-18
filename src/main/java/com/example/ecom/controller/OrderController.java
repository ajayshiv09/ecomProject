package com.example.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecom.model.Cart;
import com.example.ecom.model.Order;
import com.example.ecom.service.OrderService;

@Controller("/Order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PutMapping("/createOrder")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.OK);
	}

	@PostMapping("/createNewCart")
	public ResponseEntity<?> createNewCart(@RequestBody Cart cart) {
		return new ResponseEntity<>(orderService.createNewCart(cart), HttpStatus.OK);
	}

	@PostMapping("/makePayment")
	public ResponseEntity<?> makePayment(@RequestParam(name = "orderId", required = true) Integer orderId,
			@RequestParam(name = "transactionType", required = true) String transactionType) {
		return new ResponseEntity<>(orderService.makePayment(orderId, transactionType),
				HttpStatus.OK);
	}

	@PostMapping("/addProductToCart")
	public ResponseEntity<?> addProductToCart(@RequestParam(name = "productId", required = true) String productId,
			@RequestParam(name = "quantity", required = true) Integer quantity,
			@RequestParam(name = "cartId", required = true) Integer cartId) {
		return new ResponseEntity<>(orderService.addProductToCart(cartId, quantity, cartId), HttpStatus.OK);
	}

}
