package com.example.ecom.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ecom.model.Cart;
import com.example.ecom.model.LineItem;
import com.example.ecom.model.Order;
import com.example.ecom.model.OrderStatus;
import com.example.ecom.model.OrderTransaction;
import com.example.ecom.model.Product;
import com.example.ecom.model.TransactionType;
import com.example.ecom.repository.CartRepository;
import com.example.ecom.repository.OrderRepository;
import com.example.ecom.repository.OrderTransactionRepository;
import com.example.ecom.service.OrderService;
import com.example.ecom.service.ProductService;

@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductService productService;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderTransactionRepository orderTransactionRepository;

	@Override
	public Cart addProductToCart(Integer productId, Integer quantity, Integer cartId) {
		Cart cart = getCartById(cartId);

		List<LineItem> itemList = cart.getItemList().stream().filter(item -> item.getProduct().getProductId().equals(productId))
				.collect(Collectors.toList());

		if (productService.getProductById(productId) != null
				&& productService.getProductById(productId).getProductQuantity() > quantity) {
			if (itemList != null && itemList.size() == 1) {
				itemList.get(0).setQuantity(itemList.get(0).getQuantity() + quantity);
			} else {
				cart.addItem(new LineItem(productService.getProductById(productId), quantity,cart));
			}

			productService.getProductById(productId)
					.setProductQuantity(productService.getProductById(productId).getProductQuantity() + quantity);

		}

		calculateTotalAmountForCart(cart);
		cartRepository.save(cart);
		return cart;
	}

	@Override
	public Cart deleteProductFromCart(Integer productId, Integer quantity, Integer cartId) {
		Cart cart = getCartById(cartId);

		List<LineItem> itemList = cart.getItemList().stream().filter(item -> item.getProduct().getProductId().equals(productId))
				.collect(Collectors.toList());

		if (productService.getProductById(productId) != null
				&& productService.getProductById(productId).getProductQuantity() > quantity) {
			if (itemList != null && itemList.size() == 1) {
				itemList.get(0).setQuantity(itemList.get(0).getQuantity() - quantity);
			}

			productService.getProductById(productId)
					.setProductQuantity(productService.getProductById(productId).getProductQuantity() + quantity);

		}

		calculateTotalAmountForCart(cart);
		cartRepository.save(cart);
		return cart;
	}

	private void calculateTotalAmountForCart(Cart cart) {
		BigDecimal totalAmount = BigDecimal.ZERO;
		List<LineItem> itemList = cart.getItemList();
		for (LineItem item : itemList) {
			Product product = item.getProduct();
			BigDecimal price = product.getProductPrice();
			totalAmount = totalAmount.add(price.multiply(BigDecimal.valueOf(item.getQuantity())));
		}
		;

	}

	@Override
	public Cart createNewCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order makePayment(Integer orderId, String transactionType) {
		Order order = getOrderById(orderId);
		Cart cart = order.getCart();
		OrderTransaction transaction = new OrderTransaction(TransactionType.valueOf(transactionType),
				cart.getTotalAmount());
		order.setOrderTransaction(transaction);
		order.setOrderStatus(OrderStatus.COMPLETE);
		orderRepository.save(order);
		orderTransactionRepository.save(transaction);

		return order;
	}

	@Override
	public Order getOrderById(Integer orderId) {
		return orderRepository.findById(orderId).orElse(null);
	}

	@Override
	public Cart getCartById(Integer cartId) {
		return cartRepository.findById(cartId).orElse(null);
	}

}
