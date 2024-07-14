package com.lg.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lg.demo.dto.ShoppingCart;

@Service
public interface CartService {
	public List<ShoppingCart> getShoppingCart();

	public List<ShoppingCart> getCustomerShoppingCart(int custId);

}
