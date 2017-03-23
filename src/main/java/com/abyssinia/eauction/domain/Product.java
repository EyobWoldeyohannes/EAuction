package com.abyssinia.eauction.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	@Pattern(regexp="P[1-9]+", message="{must start with letter P}") 
  	private String productId;
	
 	private String productName;
	
 	private double productUnitPrice;
 	
	private String productDescription;
	
	private boolean biddable;
	
	//private Catagory category;

	//@JsonIgnore 
	@Transient
	private MultipartFile  productImage;

	public Product() {
	}

	
	public Product(String productId, String productName, double productUnitPrice, String productDescription,
			MultipartFile productImage, boolean biddable) {
		this.productId = productId;
		this.productName = productName;
		this.productUnitPrice = productUnitPrice;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.biddable = biddable;
	}

	
	public boolean isBiddable() {
		return biddable;
	}


	public void setBiddable(boolean biddable) {
		this.biddable = biddable;
	}


	public long getId() {
		return id;
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



	public double getProductUnitPrice() {
		return productUnitPrice;
	}



	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}



	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}


	@XmlTransient  
	public MultipartFile getProductImage() {
		return productImage;
	}

	
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
