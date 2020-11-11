package com.kodilla.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
	public GetCustomerResponse getCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
		Customer customer = customerService.getCustomer(customerId).orElseThrow(() -> new CustomerNotFoundException(
				"Customer with provided id " + customerId + " not found"));
		CustomerDTO customerDTO = GetCustomerResponse.builder()
				.id(customer.getId())
				.firstName(customer.getFirstName())
				.lastName(customer.getLastName())
				.build();
		return new GetCustomerResponse(customerDTO);
	}
}
