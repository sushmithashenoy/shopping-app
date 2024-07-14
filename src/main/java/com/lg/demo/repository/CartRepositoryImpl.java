package com.lg.demo.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lg.demo.dto.ShoppingCart;

/**
 * Implementation of @CartRepository
 */
@Repository
public class CartRepositoryImpl implements CartRepository {

	RepositoryData data;

	public CartRepositoryImpl(RepositoryData data) {
		this.data = data;
	}

	@Override
	public void saveShoppingCart(ShoppingCart shoppingCart) {
		data.getShoppingCarts().add(shoppingCart);
	}

	@Override
	public List<ShoppingCart> getShoppingCart() {
		return data.getShoppingCarts();
	}

	@Override
	public List<ShoppingCart> getCustomerShoppingCart(int custId) {
		return data.getShoppingCarts().stream().filter(cart -> cart.getCustomerId() == custId)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAllShoppingCarts() {
		data.getShoppingCarts().clear();
	}

}
