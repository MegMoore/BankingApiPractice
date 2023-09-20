package com.bootcamp.practice.spring.banking.transaction;

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
@RequestMapping("/api/transactions")
public class TransactionsController {
	
	@Autowired
	private TransactionRepository tranRepo;
	
	//Get All
			@GetMapping
			public ResponseEntity<Iterable<Transaction>> getTransaction(){
				Iterable<Transaction> trans = tranRepo.findAll();
				return new ResponseEntity<Iterable<Transaction>>(trans, HttpStatus.OK);
			}
			
			//Get By Id
			@GetMapping("{id}")//get by id
			public ResponseEntity<Transaction> getTransaction(@PathVariable int id){
				if(id <= 0) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				
			}
				Optional<Transaction> tran = tranRepo.findById(id);
				if(tran.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<Transaction>(tran.get(), HttpStatus.OK);
			}
			
			
			//Post
					@PostMapping
					public ResponseEntity<Transaction> postTransaction(@RequestBody Transaction tran){
						if(tran.getId() != 0) {
							return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
						}
						tranRepo.save(tran);
						return new ResponseEntity<Transaction>(tran, HttpStatus.CREATED);
					}
					
			//Put
				@PutMapping("{id}")
				public ResponseEntity putTransaction(@PathVariable int id, @RequestBody Transaction tran) {
					if(tran.getId() != id) {
						return new ResponseEntity(HttpStatus.BAD_REQUEST);
					}
					tranRepo.save(tran);
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
					
				//Delete
				@DeleteMapping("{id}")
				public ResponseEntity deleteTransaction(@PathVariable int id) {
					if(id <= 0) {
						return new ResponseEntity(HttpStatus.BAD_REQUEST);
					}
					tranRepo.deleteById(id);
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}


}
