package com.lg.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lg.demo.dto.Product;
import com.lg.demo.service.ProductService;

/**
 * Controller class for Product
 */
@RestController
public class ProductController {

	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/updateprice")
	public List<Product> updateProducts() {
		return productService.updatePrice();
	}

}
