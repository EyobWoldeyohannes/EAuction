package com.abyssinia.eauction.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Customer;
import com.abyssinia.eauction.domain.Product;


public interface CustomerService {

	void addCustomer(Customer customer);
	
	List<Customer> getAllCustomers();

	Customer getCustomerByCustomerFirstName(String customerFirstName);
	
	void deleteCustomer(Customer customer);

}
