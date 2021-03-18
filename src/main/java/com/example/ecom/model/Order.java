package com.example.ecom.model;

import java.util.Date;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@Column(name = "order_id", nullable = false)
	private Integer orderId;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false)
	private Date orderDate;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
	private Cart cart;

	@Column(name = "transaction_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
	private OrderTransaction orderTransaction;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void generateOrderId() {
		this.orderId = new Random().nextInt();
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderTransaction getOrderTransaction() {
		return orderTransaction;
	}

	public void setOrderTransaction(OrderTransaction orderTransaction) {
		this.orderTransaction = orderTransaction;
	}

	public Order() {
		super();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer + ", cart=" + cart
				+ ", orderStatus=" + orderStatus + ", transactionId=" + orderTransaction.getTransactionId() + "]";
	}

	public Order(Integer orderId, Date orderDate, Customer customer, Cart cart, OrderStatus orderStatus,
			OrderTransaction orderTransaction) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customer = customer;
		this.cart = cart;
		this.orderStatus = orderStatus;
		this.orderTransaction = orderTransaction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((orderTransaction == null) ? 0 : orderTransaction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (orderTransaction == null) {
			if (other.orderTransaction != null)
				return false;
		} else if (!orderTransaction.equals(other.orderTransaction))
			return false;
		return true;
	}

	
}
