package com.lg.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lg.demo.dto.Product;

/**
 * Repository to load Product related data
 */
@Repository
public interface ProductRepository {
	public Product getProduct(int id);

	public List<Product> getProducts();

	void saveProduct(Product product);

	void deleteAllProducts();

	public List<Product> updatePrice();

}
