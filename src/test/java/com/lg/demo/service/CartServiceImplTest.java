package com.lg.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lg.demo.dto.Product;
import com.lg.demo.dto.ShoppingCart;
import com.lg.demo.repository.CartRepository;

@ExtendWith(SpringExtension.class)
class CartServiceImplTest {

	@Mock
	private CartRepository cartRepository;
	private CartService cartService;
	AutoCloseable autoCloseable;
	ShoppingCart cartOne;
	ShoppingCart cartTwo;
	Product productOne;
	Product productTwo;
	List<ShoppingCart> carts = new ArrayList<ShoppingCart>();

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		cartService = new CartServiceImpl(cartRepository);
		cartOne = new ShoppingCart(1, productOne, 2, 123);
		cartTwo = new ShoppingCart(2, productTwo, 1, 321);
		carts.add(cartOne);
		carts.add(cartTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	final void testUpdateProduct() {
		when(cartRepository.getShoppingCart()).thenReturn(carts);
		assertThat(cartService.getShoppingCart()).isEqualTo(carts);
	}

	@Test
	final void testGetProduct() {
		when(cartRepository.getCustomerShoppingCart(123)).thenReturn(carts);
		assertThat(cartService.getCustomerShoppingCart(123)).isEqualTo(carts);
	}

}
