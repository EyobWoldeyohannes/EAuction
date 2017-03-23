package com.abyssinia.eauction.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BidId implements Serializable{
	
	@Column(name = "CUSTOMER_ID")
	private long customerId;
	
	@Column(name = "BIDDABLE_PRODUCT_ID")
	private long biddableProductId;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getBiddableProductId() {
		return biddableProductId;
	}

	public void setBiddableProductId(long biddableProductId) {
		this.biddableProductId = biddableProductId;
	}
	
	
	
}
