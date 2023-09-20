package com.bootcamp.practice.spring.banking.customer;



import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="customers", uniqueConstraints=@UniqueConstraint(name="UIDX_Code", columnNames= {"code"}))
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	@Column(length=30, nullable=false)
	private String code = "";
	@Column(length=30, nullable=false)
	private String name = "";
	@Column(length=30, nullable=false)
	private String city = "";
	@Column(length=2, nullable=false)
	private String state = "OH";
	@Column(columnDefinition = "DATETIME (2)")
	private LocalDateTime lastTransactionDate;
	@Column(columnDefinition = "DATETIME (2)")
	private LocalDateTime createdDate = LocalDateTime.now();
	@Column(columnDefinition = "DATETIME (2)", nullable=true)
	private LocalDateTime modifiedDate;
	
	
	//getters and setters
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	private void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocalDateTime getLastTransactionDate() {
		return lastTransactionDate;
	}
	private void setLastTransactionDate(LocalDateTime lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	private void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	private void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	

}
