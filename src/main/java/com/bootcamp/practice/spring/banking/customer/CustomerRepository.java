package com.bootcamp.practice.spring.banking.customer;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Optional<Customer> findCustomerByCode(String code);
}
