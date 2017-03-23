package com.abyssinia.eauction.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abyssinia.eauction.domain.Credentials;
import com.abyssinia.eauction.domain.Member;

	@Repository
	public interface CredentialsRepository extends  CrudRepository<Credentials, String> 
	{
  	}

