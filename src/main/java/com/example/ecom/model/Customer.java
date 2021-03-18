package com.example.ecom.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.example.ecom.model.Customer;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_id", nullable = false)
	private Integer customerId;

	@Column(name = "customer_emalid", nullable = false)
	private String customerEmailid;

	@Column(name = "customer_name", nullable = false)
	private String customerName;

	@Column(name = "customer_address", nullable = false)
	private String customerAddress;

	@Column(name = "customer_contact_no", nullable = false)
	private String customerContactno;

	@OneToOne(mappedBy = "customer")
	private Cart cart;

	@OneToMany(mappedBy = "customer")
	private List<Order> orderList;

	@OneToOne
	private Customer customer;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerEmailid() {
		return customerEmailid;
	}

	public void setCustomerEmailid(String customerEmailid) {
		this.customerEmailid = customerEmailid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerContactno() {
		return customerContactno;
	}

	public void setCustomerContactno(String customerContactno) {
		this.customerContactno = customerContactno;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String customerEmailid, String customerName, String customerAddress,
			String customerContactno) {
		super();
		this.customerId = customerId;
		this.customerEmailid = customerEmailid;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerContactno = customerContactno;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerEmailid=" + customerEmailid + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress + ", customerContactno=" + customerContactno
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + ((customerContactno == null) ? 0 : customerContactno.hashCode());
		result = prime * result + ((customerEmailid == null) ? 0 : customerEmailid.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
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
		Customer other = (Customer) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerContactno == null) {
			if (other.customerContactno != null)
				return false;
		} else if (!customerContactno.equals(other.customerContactno))
			return false;
		if (customerEmailid == null) {
			if (other.customerEmailid != null)
				return false;
		} else if (!customerEmailid.equals(other.customerEmailid))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}

	public Customer getCustomer() {
	    return customer;
	}

	public void setCustomer(Customer param) {
	    this.customer = param;
	}

}
