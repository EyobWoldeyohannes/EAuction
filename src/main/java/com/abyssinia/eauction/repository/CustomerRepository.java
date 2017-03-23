package com.abyssinia.eauction.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abyssinia.eauction.domain.Customer;
import com.abyssinia.eauction.domain.Product;

	@Repository
	public interface CustomerRepository extends  CrudRepository<Customer, String> 
	{
		 @Query("SELECT c FROM Customer c where firstName = :customerFirstName")
		 Customer getCustomerByCustomerFirstName(@Param("customerFirstName") String name);
 	}

