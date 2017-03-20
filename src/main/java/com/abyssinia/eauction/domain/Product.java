package com.abyssinia.eauction.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;


@Entity
//@XmlRootElement 
public class Product implements Serializable{

	private static final long serialVersionUID = 3678107792576131001L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
  	private String productId;
	
 	private String productName;
	
 	private BigDecimal productUnitPrice;
 	
	private String productDescription;
	
	//private Catagory category;

	//@JsonIgnore 
	//private MultipartFile  productImage;

	public Product() {
		super();
	}

	
	public Product(String productId, String productName, BigDecimal productUnitPrice, String productDescription,
			MultipartFile productImage) {
		this.productId = productId;
		this.productName = productName;
		this.productUnitPrice = productUnitPrice;
		this.productDescription = productDescription;
		//this.productImage = productImage;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public BigDecimal getProductUnitPrice() {
		return productUnitPrice;
	}



	public void setProductUnitPrice(BigDecimal productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}



	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



//	public void setProductImage(MultipartFile productImage) {
//		this.productImage = productImage;
//	}
//
//
//
//	@XmlTransient  
//	public MultipartFile getProductImage() {
//		return productImage;
//	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + productName + "]";
	}
}
