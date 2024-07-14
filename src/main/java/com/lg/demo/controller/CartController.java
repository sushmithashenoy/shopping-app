package com.lg.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lg.demo.dto.ShoppingCart;
import com.lg.demo.service.CartService;


/**
 * Controller class for Cart
 */
@RestController
public class CartController {

	CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/getshoppingcarts")
	public List<ShoppingCart> getShoppingCart() {
		return cartService.getShoppingCart();
	}

	@GetMapping("/customershoppingcart/{custId}")
	public List<ShoppingCart> getCustomerShoppingCart(@PathVariable("custId") String custId) {
		return cartService.getCustomerShoppingCart(Integer.parseInt(custId));
	}
}
