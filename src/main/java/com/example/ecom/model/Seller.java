package com.example.ecom.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seller")
public class Seller {
	
	@Id
	@Column(name = "seller_id", nullable = false)
	private int sellerId;
	
	@Column(name = "seller_name", nullable = false)
	private String sellerName;
	
	@Column(name = "seller_description", nullable = true)
	private String sellerDescription;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "seller")
	private List<Product> productList;
	

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerDescription() {
		return sellerDescription;
	}

	public void setSellerDescription(String sellerDescription) {
		this.sellerDescription = sellerDescription;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerDescription="
				+ sellerDescription + "]";
	}

	public Seller() {
		super();
	}

	public Seller(int sellerId, String sellerName, String sellerDescription) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerDescription = sellerDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sellerDescription == null) ? 0 : sellerDescription.hashCode());
		result = prime * result + sellerId;
		result = prime * result + ((sellerName == null) ? 0 : sellerName.hashCode());
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
		Seller other = (Seller) obj;
		if (sellerDescription == null) {
			if (other.sellerDescription != null)
				return false;
		} else if (!sellerDescription.equals(other.sellerDescription))
			return false;
		if (sellerId != other.sellerId)
			return false;
		if (sellerName == null) {
			if (other.sellerName != null)
				return false;
		} else if (!sellerName.equals(other.sellerName))
			return false;
		return true;
	}

}
