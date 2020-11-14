package com.kodilla.customer.repository;

import com.kodilla.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Optional<Customer> findById(Long customerId);
}
