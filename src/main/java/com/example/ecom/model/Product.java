package com.example.ecom.model;

import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_id", nullable = false)
	private Integer productId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private ProductCategory productCategory;

	@Column(name = "product_price", nullable = false)
	private BigDecimal productPrice;

	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private Seller seller;

	@Column(name = "size", nullable = false)
	@Enumerated(EnumType.STRING)
	private Size size;

	@Column(name = "brand", nullable = true)
	private String brand;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "product_description", nullable = true)
	private String productDescription;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "product_add_date", nullable = false)
	private Date productAddDate;

	@Column(name = "product_rating", nullable = true)
	private Integer productRating;

	@Column(name = "product_quantity", nullable = false)
	private Integer productQuantity;

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void generateProductId() {
		this.productId = new Random().nextInt();
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Date getProductAddDate() {
		return productAddDate;
	}

	public void setProductAddDate(Date productAddDate) {
		this.productAddDate = productAddDate;
	}

	public Integer getProductRating() {
		return productRating;
	}

	public void setProductRating(Integer productRating) {
		this.productRating = productRating;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Product(ProductCategory category, BigDecimal productPrice, String produtName, Seller seller) {
		super();
		this.productId = new Random().nextInt();
		this.productCategory = category;
		this.productPrice = productPrice;
		this.seller = seller;
		this.productName = produtName;
		this.productAddDate = new Date();
	}

	public Product() {
		super();
	}

}
