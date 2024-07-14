package com.lg.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lg.demo.controller.CartController;
import com.lg.demo.controller.HomePageController;
import com.lg.demo.controller.ProductController;

@SpringBootTest
class SmokeTest {

	@Autowired
	private ProductController productController;
	
	@Autowired
	private HomePageController homePageController;
	
	@Autowired
	private CartController cartController;

	@Test
	void contextLoads() throws Exception {
		assertThat(productController).isNotNull();
		assertThat(homePageController).isNotNull();
		assertThat(cartController).isNotNull();
}
}