package com.lg.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lg.demo.dto.Product;
import com.lg.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	public ProductRepository repository;

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> getProducts() {
		return repository.getProducts();
	}

	@Override
	public List<Product> updatePrice() {
		return repository.updatePrice();
	}

}
