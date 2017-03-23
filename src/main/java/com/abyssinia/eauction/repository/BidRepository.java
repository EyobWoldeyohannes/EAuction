package com.abyssinia.eauction.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abyssinia.eauction.domain.Bid;
import com.abyssinia.eauction.domain.BidId;
import com.abyssinia.eauction.domain.Product;

	@Repository
	public interface BidRepository extends  CrudRepository<Bid, Long> 
	{
		 @Query("SELECT b FROM Bid b where CUSTOMER_ID = :customerId")
		 List<Bid> getBidByCustomerId(@Param("customerId") Long customerId);
		
		 @Query("SELECT b FROM Bid b where BIDDABLE_PRODUCT_ID = :biddableProductId")
		 List<Bid> getBidByBiddableProductId(@Param("biddableProductId") Long biddableProductId);
		
		 @Query("SELECT b FROM Bid b where CUSTOMER_ID = :customerId AND BIDDABLE_PRODUCT_ID = :biddableProductId")
		 Bid getBidByCustomerIdAndBiddableProductId(@Param("customerId") Long customerId, @Param("biddableProductId") Long biddableProductId);
 	}

