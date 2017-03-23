package com.abyssinia.eauction.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.abyssinia.eauction.domain.BiddableProduct;
import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Product;


public interface BiddableProductService {

	void addBiddableProduct(BiddableProduct biddableProduct);
	
	List<BiddableProduct> getAllBiddableProducts();
	
	List<Product> getAllBiddableProductsFromParent();

	BiddableProduct getBiddableProductByProductId(String productID);
	BiddableProduct getBiddableProductById(Long id);
	
//	List<BiddableProduct> getBiddableProductsByCategory(Category category);

	Set<BiddableProduct> getBiddableProductsByFilter(Map<String, List<String>> filterParams);
	
	void deleteBiddableProduct(BiddableProduct biddableProduct);

}
