package com.abyssinia.eauction.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Product;
import com.abyssinia.eauction.repository.ProductRepository;
import com.abyssinia.eauction.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return ((ProductService) productRepository).getAllProducts();
	}

	public Product getProductById(String productID) {
		return ((ProductService) productRepository).getProductById(productID);
	}
	
	public List<Product> getProductsByCategory(Category category) {
		return ((ProductService) productRepository).getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return ((ProductService) productRepository).getProductsByFilter(filterParams);
	}
	
	public void addProduct(Product product) {
		   ((ProductService) productRepository).addProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		 ((ProductService) productRepository).deleteProduct(product);
	}

}
