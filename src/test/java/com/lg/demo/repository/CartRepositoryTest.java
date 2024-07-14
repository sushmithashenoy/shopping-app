package com.lg.demo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lg.demo.dto.Product;
import com.lg.demo.dto.ShoppingCart;

@ExtendWith(SpringExtension.class)
public class CartRepositoryTest {

	private CartRepository cartRepository;

	@Mock
	RepositoryData data;

	ShoppingCart cartOne;
	ShoppingCart cartTwo;
	Product productOne;
	Product productTwo;
	List<ShoppingCart> carts = new ArrayList<ShoppingCart>();

	@BeforeEach
	void setUp() {
		data = Mockito.mock(RepositoryData.class);
		cartRepository = new CartRepositoryImpl(data);
		productOne = new Product(1, "Sony Ericsson W595 Original Slide", 6990);
		productTwo = new Product(2, "Sony Ericsson W550i", 12999);
		cartOne = new ShoppingCart(1, productOne, 2, 123);
		cartTwo = new ShoppingCart(2, productTwo, 1, 321);
		carts.add(cartOne);
		carts.add(cartTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
		carts.clear();
	}

	/* Test for get ShoppingCarts */
	@Test
	void testGetShoppingCarts_Found() {
		when(data.getShoppingCarts()).thenReturn(carts);
		List<ShoppingCart> cartList = cartRepository.getShoppingCart();
		assertThat(cartList.isEmpty()).isFalse();
		assertTrue(cartList.getFirst() == cartOne);
		assertTrue(cartList.getFirst().getId() == 1);
		assertThat(cartList.getFirst().getProduct()).isEqualTo(productOne);
		assertTrue(cartList.getFirst().getQuantity() == 2);
		assertTrue(cartList.getFirst().getCustomerId() == 123);
	}

	/* Test case empty list for get Shopping carts */
	@Test
	void testGetShoppingCarts_Empty() {
		when(data.getShoppingCarts()).thenReturn(Collections.emptyList());
		List<ShoppingCart> cartList = cartRepository.getShoppingCart();
		assertTrue(cartList.isEmpty());
	}

	/* Test for get ShoppingCarts of a specific customer */
	@Test
	void testGetCustomerShoppingCarts_Found() {
		when(data.getShoppingCarts()).thenReturn(carts);
		List<ShoppingCart> cartList = cartRepository.getCustomerShoppingCart(321);
		assertTrue(cartList.size() == 1);
		assertTrue(cartList.getFirst() == cartTwo);
		assertTrue(cartList.getFirst().getId() == 2);
		assertThat(cartList.getFirst().getProduct()).isEqualTo(productTwo);
		assertTrue(cartList.getFirst().getQuantity() == 1);
		assertTrue(cartList.getFirst().getCustomerId() == 321);
	}

	/* Test case empty list for get customer Shopping carts */
	@Test
	void testGetCustomerShoppingCarts_Empty() {
		when(data.getShoppingCarts()).thenReturn(Collections.emptyList());
		List<ShoppingCart> cartList = cartRepository.getCustomerShoppingCart(321);
		assertTrue(cartList.isEmpty());
	}

}
