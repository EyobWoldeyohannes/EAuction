package com.abyssinia.eauction.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.abyssinia.eauction.domain.Bid;
import com.abyssinia.eauction.domain.BidId;
import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Customer;
import com.abyssinia.eauction.domain.Product;


public interface BidService {

	void addBid(Bid bid);
	
	List<Bid> getAllBids();

	Bid getBidById(Long bidId);
	
	List<Bid> getBidsByCustomerId(Long customerId);
	
	List<Bid> getBidsByBiddableProductId(Long biddableProductId);

	Bid getBidByCustomerIdAndBiddableProductId(Long customerId, Long biddableProductId);
	//Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	//void deleteProduct(Product product);

}
