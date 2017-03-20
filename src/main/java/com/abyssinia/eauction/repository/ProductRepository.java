package com.abyssinia.eauction.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abyssinia.eauction.domain.Product;

	@Repository
	public interface ProductRepository extends  CrudRepository<Product, String> 
	{
		//public Product findByMemberNumber(int memberNumber);
 	}

