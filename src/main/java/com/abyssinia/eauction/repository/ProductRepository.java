package com.abyssinia.eauction.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abyssinia.eauction.domain.Product;

	@Repository
	public interface ProductRepository extends  CrudRepository<Product, String> 
	{
		//public Product findByMemberNumber(int memberNumber);
		 @Query("SELECT p FROM Product p where productId = :productId")
		 Product getProductByProductId(@Param("productId") String key);
 	}

