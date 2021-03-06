package com.abyssinia.eauction.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abyssinia.eauction.domain.Product;

	//@Repository
	@Transactional
	//public interface ProductRepository extends  CrudRepository<Product, String> 
	public interface ProductRepository extends  BaseRepository<Product> 
	{
		//public Product findByMemberNumber(int memberNumber);
		 @Query("SELECT p FROM Product p where productId = :productId")
		 Product getProductByProductId(@Param("productId") String key);
		 
		 @Query("SELECT p FROM Product p where biddable = false")
		 List<Product> findAllUnbiddable();
		 
		 @Query("SELECT p FROM Product p where biddable = true")
		 List<Product> findAllBiddable();
		 
 	}

