package com.bootcamp.practice.spring.banking.account;

import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<Account, Integer> {
	
}
