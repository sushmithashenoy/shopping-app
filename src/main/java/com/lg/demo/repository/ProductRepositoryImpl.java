package com.lg.demo.repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lg.demo.dto.Product;

/**
 * Implementation of ProductRepository
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {
	RepositoryData data;

	ApplicationUtil util;

	public ProductRepositoryImpl(RepositoryData data, ApplicationUtil util) {
		this.data = data;
		this.util = util;
	}

	@Override
	public void saveProduct(Product product) {
		data.getProducts().add(product);
	}

	@Override
	public Product getProduct(int id) throws NoSuchElementException {
		return data.getProducts().stream().filter(product -> product.getId() == id).collect(Collectors.toList())
				.getFirst();
	}

	@Override
	public List<Product> getProducts() {
		return data.getProducts();
	}

	@Override
	public void deleteAllProducts() {
		data.getProducts().clear();
	}

	@Override
	public List<Product> updatePrice() {
		List<Product> products = data.getProducts();
		if (!products.isEmpty()) {
			int index = util.randomNumber(0, products.size());
			Product product = products.get(index);
			int price = product.getPrice();
			product.setPrice(util.randomNumber(price, price + 1000));
		}
		return products;
	}

}
