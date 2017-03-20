package com.abyssinia.eauction.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Product;


public interface ProductService {

	void addProduct(Product product);
	
	List<Product> getAllProducts();

	Product getProductByProductId(String productID);
	
	List<Product> getProductsByCategory(Category category);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void deleteProduct(Product product);
	
}
