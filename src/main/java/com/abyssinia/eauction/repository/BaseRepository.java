package com.abyssinia.eauction.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.abyssinia.eauction.domain.Product;

	@NoRepositoryBean
	public interface BaseRepository<T extends Product> extends  CrudRepository<T, Long> 
	{
		
		 
 	}

