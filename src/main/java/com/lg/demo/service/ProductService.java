package com.lg.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lg.demo.dto.Product;

@Service
public interface ProductService {

	public List<Product> getProducts();

	public List<Product> updatePrice();

}
