package com.lg.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lg.demo.dto.ShoppingCart;

/**
 * Repository to load Cart related data
 */
@Repository
public interface CartRepository {
	public List<ShoppingCart> getShoppingCart();

	public void saveShoppingCart(ShoppingCart shoppingCart);

	public void deleteAllShoppingCarts();

	public List<ShoppingCart> getCustomerShoppingCart(int custId);
}
