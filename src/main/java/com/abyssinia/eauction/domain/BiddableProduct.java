package com.abyssinia.eauction.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;





@Entity
public class BiddableProduct extends Product{
//	@Id 
//	private long id;
//	
	private Date startDate;
	private Date endDate;
	private double bidPrice;
	private float payPerBid;
	private double profit ;
	private String status;
	private double soldPrice;
	

	public BiddableProduct() {
		//super();
	}

	public BiddableProduct(String productId, String productName, double productUnitPrice, String productDescription,
			MultipartFile productImage, Date startDate, Date endDate, double bidPrice, float payPerBid,
			double profit, String status, boolean biddable) {
		super(productId, productName, productUnitPrice, productDescription, productImage, biddable);
		this.startDate = startDate;
		this.endDate = endDate;
		this.bidPrice = bidPrice;
		this.payPerBid = payPerBid;
		this.profit = profit;
		this.status = status;
		this.setSoldPrice(bidPrice);
	}

	
	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public float getPayPerBid() {
		return payPerBid;
	}

	public void setPayPerBid(float payPerBid) {
		this.payPerBid = payPerBid;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((super.getProductId() == null) ? 0 : super.getProductId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BiddableProduct other = (BiddableProduct) obj;
		if (super.getProductId() == null) {
			if (other.getProductId() != null)
				return false;
		} else if (!super.getProductId().equals(other.getProductId()))
			return false;
		return true;
	}

	
	
}
