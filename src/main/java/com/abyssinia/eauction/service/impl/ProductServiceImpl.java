package com.abyssinia.eauction.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Product;
import com.abyssinia.eauction.repository.ProductRepository;
import com.abyssinia.eauction.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return (List<Product>)productRepository.findAll();
	}

	public Product getProductByProductId(String productID) {
		return (Product)productRepository.getProductByProductId(productID);
	}

	
//	public List<Product> getProductsByCategory(Category category) {
//		return ((ProductService) productRepository).getProductsByCategory(category);
//	}
//
//	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
//		return ((ProductService) productRepository).getProductsByFilter(filterParams);
//	}
	
	public void addProduct(Product product) {
		   productRepository.save(product);
		   
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	@Override
	public List<Product> getProductsByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
