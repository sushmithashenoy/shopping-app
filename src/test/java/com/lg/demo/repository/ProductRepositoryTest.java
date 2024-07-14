package com.lg.demo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
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

@ExtendWith(SpringExtension.class)
public class ProductRepositoryTest {

	private ProductRepository productRepository;

	@Mock
	RepositoryData data;

	@Mock
	ApplicationUtil util;

	Product productOne;
	Product productTwo;
	List<Product> products = new ArrayList<Product>();

	@BeforeEach
	void setUp() {
		data = Mockito.mock(RepositoryData.class);
		util = Mockito.mock(ApplicationUtil.class);
		productRepository = new ProductRepositoryImpl(data, util);
		productOne = new Product(1, "Sony Ericsson W595 Original Slide", 6990);
		productTwo = new Product(2, "Sony Ericsson W550i", 12999);
		products.add(productOne);
		products.add(productTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
		products.clear();
	}

	/* Test for get products */
	@Test
	void testGetProducts_Found() {
		when(data.getProducts()).thenReturn(products);
		List<Product> productList = productRepository.getProducts();
		assertThat(productList.isEmpty()).isFalse();
		assertTrue(productList.getFirst() == productOne);
		assertTrue(productList.getFirst().getId() == 1);
		assertThat(productList.getFirst().getName()).isEqualTo("Sony Ericsson W595 Original Slide");
		assertTrue(productList.getFirst().getPrice() == 6990);
	}

	/* Test case empty list for get products */
	@Test
	void testGetProducts_NotFound() {
		when(data.getProducts()).thenReturn(Collections.emptyList());
		List<Product> productList = productRepository.getProducts();
		assertTrue(productList.isEmpty());
	}

	/* Test for Update Products */
	@Test
	void testUpdateProducts_UpdatesPrice() {
		when(data.getProducts()).thenReturn(products);
		when(util.randomNumber(anyInt(), anyInt())).thenReturn(1);
		List<Product> productList = productRepository.updatePrice();
		assertThat(productList.isEmpty()).isFalse();
		assertTrue(productList.get(1) == productTwo);
		assertTrue(productList.get(1).getId() == 2);
		assertThat(productList.get(1).getName()).isEqualTo("Sony Ericsson W550i");
		assertTrue(productList.get(1).getPrice() == 1);
	}

	/* Test case empty list for Update Products */
	@Test
	void testUpdateProducts_UpdatesSinglePrice() {
		when(data.getProducts()).thenReturn(Collections.emptyList());
		when(util.randomNumber(anyInt(), anyInt())).thenReturn(1);
		List<Product> productList = productRepository.updatePrice();
		assertTrue(productList.isEmpty());
	}

}
