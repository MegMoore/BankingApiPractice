package com.bootcamp.practice.spring.banking.transaction;

import java.time.LocalDateTime;

import com.bootcamp.practice.spring.banking.account.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="accountId")
	private Account account;
	
	@Column(columnDefinition="decimal (11,2) not null")
	private double previousBalance = 0;
	@Column(length=1, nullable=false)
	private String type = "";
	@Column(columnDefinition="decimal (11,2) not null")
	private double newBalance = 0;
	@Column(length=30, nullable=false)
	private String description = "";
	@Column(columnDefinition = "DATETIME (2)")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public double getPreviousBalance() {
		return previousBalance;
	}
	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
