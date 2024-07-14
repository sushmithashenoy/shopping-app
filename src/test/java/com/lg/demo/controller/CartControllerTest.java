package com.lg.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.lg.demo.dto.Product;
import com.lg.demo.dto.ShoppingCart;
import com.lg.demo.service.CartService;

@WebMvcTest(CartController.class)

public class CartControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CartService cartService;

	Product productOne;
	Product productTwo;
	ShoppingCart cartOne;
	ShoppingCart cartTwo;
	List<ShoppingCart> carts = new ArrayList<ShoppingCart>();
	AutoCloseable autoclosable;

	@BeforeEach
	void setUp() {
		autoclosable = MockitoAnnotations.openMocks(mockMvc);
		productOne = new Product(1,"Sony Ericsson W595 Original Slide",6990 );
		productTwo = new Product(2, "Sony Ericsson W550i",12999);
		cartOne = new ShoppingCart(1, productOne, 2, 123);
		cartTwo = new ShoppingCart(2, productTwo, 1, 321);
		carts.add(cartOne);
		carts.add(cartTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
		carts.clear();
		autoclosable.close();
	}

	/**
	 * test for the get end point "/getshoppingcarts"
	 * @throws Exception
	 */
	@Test
	public void testGetShoppingCart() throws Exception {
		when(cartService.getShoppingCart()).thenReturn(carts);
		this.mockMvc.perform(get("/getshoppingcarts")).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * test for the get end point "/customershoppingcart/{custId}"
	 * @throws Exception
	 */
	@Test
	public void testGetCustomerShoppingCart() throws Exception {
		when(cartService.getCustomerShoppingCart(123)).thenReturn(carts);
		this.mockMvc.perform(get("/customershoppingcart/"+123)).andDo(print()).andExpect(status().isOk());
	}


}
