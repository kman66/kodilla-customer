package com.kodilla.customer.service;

import com.kodilla.customer.dto.CustomerDTO;
import com.kodilla.customer.mapper.GetCustomerResponse;
import com.kodilla.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Optional<CustomerDTO> getCustomer(Long customerId) {
		return customerRepository.findById(customerId)
				.map(customer -> GetCustomerResponse.builder()
						.id(customer.getId())
						.firstName(customer.getFirstName())
						.lastName(customer.getLastName())
						.build());
	}
}
