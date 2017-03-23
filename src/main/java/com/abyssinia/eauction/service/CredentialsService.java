package com.abyssinia.eauction.service;

import java.util.List;

import com.abyssinia.eauction.domain.Credentials;
import com.abyssinia.eauction.domain.Member;
 
public interface CredentialsService {

	public void save(Credentials credentials);
	public List<Credentials> findAll();
 }
