package com.abyssinia.eauction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abyssinia.eauction.domain.Customer;
import com.abyssinia.eauction.repository.CustomerRepository;
import com.abyssinia.eauction.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return (List<Customer>)customerRepository.findAll();
	}

	public Customer getCustomerByCustomerFirstName(String customerFirstName) {
		return (Customer)customerRepository.getCustomerByCustomerFirstName(customerFirstName);
	}
	
	public void addCustomer(Customer customer) {
		   customerRepository.save(customer);
		   
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	
}
