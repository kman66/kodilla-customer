package com.kodilla.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Optional<Customer> getCustomer(Long customerId) {
		return customerRepository.findById(customerId);
	}
}
