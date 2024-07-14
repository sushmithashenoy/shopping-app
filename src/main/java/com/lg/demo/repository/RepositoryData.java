package com.lg.demo.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lg.demo.dto.Product;
import com.lg.demo.dto.ShoppingCart;

/**
 * This class that holds the data would be ideally replaced by a database
 */
@Component
public class RepositoryData {
	private List<Product> products;
	private List<ShoppingCart> shoppingCarts;

	public RepositoryData() {
		Product productOne = new Product(10, "X", 500);
		Product productTwo = new Product(11, "Y", 400);
		Product productThree = new Product(12, "Z", 300);
		products = Arrays.asList(productOne, productTwo, productThree);
		shoppingCarts = Arrays.asList(new ShoppingCart(1, productOne, 5, 123), new ShoppingCart(2, productTwo, 3, 123),
				new ShoppingCart(3, productThree, 4, 123), new ShoppingCart(1, productOne, 5, 12),
				new ShoppingCart(2, productOne, 5, 12), new ShoppingCart(3, productThree, 1, 13),
				new ShoppingCart(1, productOne, 2, 1), new ShoppingCart(2, productTwo, 2, 23),
				new ShoppingCart(3, productOne, 4, 2));
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

}