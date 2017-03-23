package com.abyssinia.eauction.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abyssinia.eauction.domain.BiddableProduct;
import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Product;
import com.abyssinia.eauction.repository.BiddableProductRepository;
import com.abyssinia.eauction.repository.ProductRepository;
import com.abyssinia.eauction.service.BiddableProductService;

@Service
@Transactional
public class BiddableProductServiceImpl implements BiddableProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BiddableProductRepository biddableProductRepository;

	@Override
	public void addBiddableProduct(BiddableProduct biddableProduct) {
		// TODO Auto-generated method stub
		biddableProductRepository.save(biddableProduct);
		
	}

	@Override
	public List<BiddableProduct> getAllBiddableProducts() {
		//return (List<BiddableProduct>)biddableProductRepository.findAllBiddableProducts();
		
		return (List<BiddableProduct>)biddableProductRepository.findAll();
//		List<BiddableProduct> biddableProducts = new ArrayList<BiddableProduct>();
//		
//		for(Product p : products){
//			if(p instanceof BiddableProduct){
//				biddableProducts.add((BiddableProduct)p);
//			}
//		}
//		return biddableProducts;
		
	}
	
	@Override
	public List<Product> getAllBiddableProductsFromParent() {
		// TODO Auto-generated method stub
		//return (List<BiddableProduct>)biddableProductRepository.findAll();
		return (List<Product>)productRepository.findAllBiddable();
		
//		return (List<Product>)productRepository.findAllBiddable();
		
	}

	@Override
	public BiddableProduct getBiddableProductByProductId(String productId) {
		// TODO Auto-generated method stub
		return (BiddableProduct)biddableProductRepository.getBiddableProductByProductId(productId);
	}

//	@Override
//	public List<BiddableProduct> getBiddableProductsByCategory(Category category) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Set<BiddableProduct> getBiddableProductsByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBiddableProduct(BiddableProduct biddableProduct) {
		// TODO Auto-generated method stub
		biddableProductRepository.delete(biddableProduct);
	}

	@Override
	public BiddableProduct getBiddableProductById(Long id) {
		return (BiddableProduct)biddableProductRepository.findOne(id);
	}

	
	
}
