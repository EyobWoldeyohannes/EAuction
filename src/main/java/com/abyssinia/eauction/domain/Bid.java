package com.abyssinia.eauction.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Bid{
	
	//private static final long serialVersionUID = 1L;

	@Id 
	//@GeneratedValue
	@JsonProperty("id")
	private long id;
	
//	@OneToOne
//	@JoinColumn(name= "CUSTOMER_ID", insertable = false, updatable = false)
//	Customer customer;
	@JsonProperty("CUSTOMER_ID")
	private long CUSTOMER_ID;
	
	@JsonProperty("BIDDABLE_PRODUCT_ID")
	private long BIDDABLE_PRODUCT_ID;
	
//	@OneToOne
//	@JoinColumn(name = "BIDDABLE_PRODUCT_ID")
//	BiddableProduct biddableProduct;
//	
//	@ManyToOne
//	@JoinColumn(name= "CUSTOMER_ID")
//	Customer customer;
	@JsonProperty("amount")
 	private double amount;
 	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("soldPrice")
	private double soldPrice;
 	
	
	public Bid() {
	}


	public Bid(double amount, String status, double soldPrice) {
		this.amount = amount;
		this.status = status;
		this.soldPrice = soldPrice;
	}


	

	public long getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}


	public void setCUSTOMER_ID(long cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}


	public long getBIDDABLE_PRODUCT_ID() {
		return BIDDABLE_PRODUCT_ID;
	}


	public void setBIDDABLE_PRODUCT_ID(long bIDDABLE_PRODUCT_ID) {
		BIDDABLE_PRODUCT_ID = bIDDABLE_PRODUCT_ID;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public double getSoldPrice() {
		return soldPrice;
	}


	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}


//	public BiddableProduct getBiddableProduct() {
//		return biddableProduct;
//	}
//
//
//	public void setBiddableProduct(BiddableProduct biddableProduct) {
//		this.biddableProduct = biddableProduct;
//	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//	
	
	
	
	
}
