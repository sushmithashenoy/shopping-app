package com.lg.demo.dto;

/**
 * Class that represents information related to shopping cart of the customers. 
 */
public class ShoppingCart {
	int id;
	Product product;
	int quantity;
	int customerId;

	public ShoppingCart(int id,Product product, int quantity, int customerId) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product productId) {
		this.product = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", product=" + product + ", quantity=" + quantity + ", customerId="
				+ customerId + "]";
	}



}
