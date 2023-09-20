package com.bootcamp.practice.spring.banking.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.practice.spring.banking.customer.Customer;
import com.bootcamp.practice.spring.banking.customer.CustomerRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accRepo;
	
	//Get All
		@GetMapping
		public ResponseEntity<Iterable<Account>> getAccount(){
			Iterable<Account> accs = accRepo.findAll();
			return new ResponseEntity<Iterable<Account>>(accs, HttpStatus.OK);
		}
		
		//Get By Id
		@GetMapping("{id}")//get by id
		public ResponseEntity<Account> getAccount(@PathVariable int id){
			if(id <= 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
			Optional<Account> acc = accRepo.findById(id);
			if(acc.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Account>(acc.get(), HttpStatus.OK);
		}
		
		
		//Post
				@PostMapping
				public ResponseEntity<Account> postAccount(@RequestBody Account acc){
					if(acc.getId() != 0) {
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}
					accRepo.save(acc);
					return new ResponseEntity<Account>(acc, HttpStatus.CREATED);
				}
				
		//Put
			@PutMapping("{id}")
			public ResponseEntity putAccount(@PathVariable int id, @RequestBody Account acc) {
				if(acc.getId() != id) {
					return new ResponseEntity(HttpStatus.BAD_REQUEST);
				}
				accRepo.save(acc);
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
				
			//Delete
			@DeleteMapping("{id}")
			public ResponseEntity deleteAccount(@PathVariable int id) {
				if(id <= 0) {
					return new ResponseEntity(HttpStatus.BAD_REQUEST);
				}
				accRepo.deleteById(id);
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

				
				
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
