package com.kodilla.customer.controller;

import com.kodilla.customer.dto.AccountDTO;
import com.kodilla.customer.dto.CustomerDTO;
import com.kodilla.customer.mapper.GetCustomerProductsResponse;
import com.kodilla.customer.mapper.GetCustomerResponse;
import com.kodilla.customer.service.CustomerService;
import com.kodilla.customer.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
	public GetCustomerResponse getCustomer(@PathVariable Long customerId) {
		return customerService.getCustomer(customerId)
				.map(GetCustomerResponse::new)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{customerId}/products")
	public GetCustomerProductsResponse getCustomerProducts(@PathVariable Long customerId) {
		CustomerDTO customerDTO = customerService.getCustomer(customerId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

		List<AccountDTO> customerAccounts = productService.findCustomerAccounts(customerId);

		return GetCustomerProductsResponse.builder()
				.customerId(customerDTO.getId())
				.fullName(customerDTO.getFirstName() + " " + customerDTO.getLastName())
				.accounts(customerAccounts)
				.build();
	}
}
