package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="vendor_map_product" , uniqueConstraints=
	@UniqueConstraint(columnNames={"product_id"})
)
public class VendorMapProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="product_id")
	private String product_id;
	
	@Column(name="vendor_id")
	private String vendor_id;
	
	public VendorMapProduct() {}

	public VendorMapProduct(String product_id, String vendor_id) {
		super();
		this.product_id = product_id;
		this.vendor_id = vendor_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}
	
	
	
	
}
