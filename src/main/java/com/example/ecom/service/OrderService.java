package com.example.ecom.service;

import com.example.ecom.model.Cart;
import com.example.ecom.model.Order;

public interface OrderService {
	Cart createNewCart(Cart cart);
	Cart addProductToCart(Integer productId, Integer quantity, Integer cartId);
	Cart deleteProductFromCart(Integer productId, Integer quantity, Integer cartId);
	Order createOrder(Order order);
	Order makePayment(Integer orderId, String transactionType);
	Order getOrderById(Integer orderId);
	Cart getCartById(Integer cartId);

}
