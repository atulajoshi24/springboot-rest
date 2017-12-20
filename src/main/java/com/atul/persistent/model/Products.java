// default package
// Generated Mar 4, 2017 6:36:25 PM by Hibernate Tools 5.2.1.Final

package com.atul.persistent.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name="products")
public class Products implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1895580713896126954L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String description;
	private double minBalance;
	

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMinBalance() {
		return this.minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}


}
