package com.abyssinia.eauction.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abyssinia.eauction.domain.BiddableProduct;
import com.abyssinia.eauction.domain.Product;

	//@Repository
	@Transactional
	//public interface BiddableProductRepository extends  CrudRepository<BiddableProduct, Long> 
	public interface BiddableProductRepository extends BaseRepository<BiddableProduct> 
	
	{
		//public Product findByMemberNumber(int memberNumber);
		 @Query("SELECT p FROM BiddableProduct p where productId = :productId")
		 BiddableProduct getBiddableProductByProductId(@Param("productId") String key);
		 
		 @Query("SELECT p FROM BiddableProduct p where biddable = true")
		 List<BiddableProduct> findAllBiddableProducts();
 	}

