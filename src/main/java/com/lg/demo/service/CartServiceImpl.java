package com.lg.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lg.demo.dto.ShoppingCart;
import com.lg.demo.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	public CartRepository repository;

	public CartServiceImpl(CartRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<ShoppingCart> getShoppingCart() {
		return repository.getShoppingCart();
	}

	@Override
	public List<ShoppingCart> getCustomerShoppingCart(int custId) {
		return repository.getCustomerShoppingCart(custId);
	}
}