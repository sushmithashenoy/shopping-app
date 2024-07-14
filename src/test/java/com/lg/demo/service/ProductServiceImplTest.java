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
import com.lg.demo.repository.ProductRepository;

@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {

	@Mock
	private ProductRepository productRepository;
	private ProductService productService;
	AutoCloseable autoCloseable;
	Product productOne;
	Product productTwo;
	List<Product> products = new ArrayList<Product>();

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		productService = new ProductServiceImpl(productRepository);
		productOne = new Product(1, "Sony Ericsson W595 Original Slide", 6990);
		productTwo = new Product(2, "Sony Ericsson W550i", 12999);
		products.add(productOne);
		products.add(productTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	final void testUpdateProduct() {
		when(productRepository.updatePrice()).thenReturn(products);
		assertThat(productService.updatePrice()).isEqualTo(products);
	}

	@Test
	final void testGetProduct() {
		when(productRepository.getProducts()).thenReturn(products);
		assertThat(productService.getProducts()).isEqualTo(products);
	}

}
