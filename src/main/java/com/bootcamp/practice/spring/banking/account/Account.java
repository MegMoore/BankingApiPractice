package com.bootcamp.practice.spring.banking.account;

import java.time.LocalDateTime;

import com.bootcamp.practice.spring.banking.customer.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	@Column(length=2, nullable=false)
	private String type = "CK";
	@Column(length=30, nullable=false)
	private String description = "";
	@Column(columnDefinition="decimal (11,2) not null")
	private double interestRate = 0.00;
	@Column(columnDefinition="decimal (11,2) not null")
	private double balance = 0;
	@Column(columnDefinition = "DATETIME (2)")
	private LocalDateTime createdDate = LocalDateTime.now();
	@Column(columnDefinition = "DATETIME (2)", nullable=true)
	private LocalDateTime modifiedDate;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="customerId")
	private Customer customer;

	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	} 
	
	
}







