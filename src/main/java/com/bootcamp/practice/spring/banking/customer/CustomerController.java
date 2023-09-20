package com.bootcamp.practice.spring.banking.customer;

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

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository custRepo;
	
	//Get All
	@GetMapping
	public ResponseEntity<Iterable<Customer>> getCustomer(){
		Iterable<Customer> custs= custRepo.findAll();
		return new ResponseEntity<Iterable<Customer>>(custs, HttpStatus.OK);
	}
	//Get By Id
	@GetMapping("{id}")//get by id
	public ResponseEntity<Customer> getCustomer(@PathVariable int id){
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
		Optional<Customer> cust = custRepo.findById(id);
		if(cust.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(cust.get(), HttpStatus.OK);
	}
	
	//Get By Code
	@GetMapping("code/{code}")//get customer by code
	public ResponseEntity<Customer> getCustomerByCode(@PathVariable String code){
		Optional<Customer> cust = custRepo.findCustomerByCode(code);
		if(cust.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(cust.get(), HttpStatus.OK);
	
	}
	
	//Post
		@PostMapping
		public ResponseEntity<Customer> postCustomer(@RequestBody Customer cust){
			if(cust.getId() != 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			custRepo.save(cust);
			return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
		}
		
		//Put
		@PutMapping("{id}")
		public ResponseEntity putCustomer(@PathVariable int id, @RequestBody Customer cust) {
			if(cust.getId() != id) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			custRepo.save(cust);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//Delete
		@DeleteMapping("{id}")
		public ResponseEntity deleteCustomer(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			custRepo.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

}
