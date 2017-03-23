package com.abyssinia.eauction.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abyssinia.eauction.domain.Bid;
import com.abyssinia.eauction.domain.BidId;
import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Customer;
import com.abyssinia.eauction.domain.Product;
import com.abyssinia.eauction.repository.BidRepository;
import com.abyssinia.eauction.repository.ProductRepository;
import com.abyssinia.eauction.service.BidService;
import com.abyssinia.eauction.service.ProductService;

@Service
@Transactional
public class BidServiceImpl implements BidService{
	
	@Autowired
	private BidRepository bidRepository;

	@Override
	public void addBid(Bid bid) {
		bidRepository.save(bid);
	}

	@Override
	public List<Bid> getAllBids() {
		return (List<Bid>)bidRepository.findAll();
	}


	@Override
	public List<Bid> getBidsByCustomerId(Long customerId) {
		 return (List<Bid>)bidRepository.getBidByCustomerId(customerId);
	}

	@Override
	public List<Bid> getBidsByBiddableProductId(Long biddableProductId) {
		return (List<Bid>)bidRepository.getBidByBiddableProductId(biddableProductId);
	}

	@Override
	public Bid getBidById(Long bidId) {
		return (Bid) bidRepository.findOne(bidId);
	}

	@Override
	public Bid getBidByCustomerIdAndBiddableProductId(Long customerId, Long biddableProductId) {
		return (Bid)bidRepository.getBidByCustomerIdAndBiddableProductId(customerId, biddableProductId);
	}

	
}
