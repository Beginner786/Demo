package com.example.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="product", uniqueConstraints=
	@UniqueConstraint(columnNames={"product_id"})
)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="product_id")
	private String product_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="unit_price")
	private Double unit_price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productId_productId")
	private VendorMapProduct vendorMapProduct;
	
	@Column(name="description")
	private String description;
	
	@Column(name="added_on")
	private Timestamp added_on;
	
	@Column(name="added_by")
	private String added_by;
	
	@Column(name="updated_on")
	private Timestamp updated_on;
	
	@Column(name="updated_by")
	private String updated_by;
	
	public Product() {}

	public Product(String product_id, String name, Double unit_price, String description) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.unit_price = unit_price;
		this.description = description;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getAdded_on() {
		return added_on;
	}

	public void setAdded_on(Timestamp added_on) {
		this.added_on = added_on;
	}

	public String getAdded_by() {
		return added_by;
	}

	public void setAdded_by(String added_by) {
		this.added_by = added_by;
	}

	public Timestamp getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Timestamp updated_on) {
		this.updated_on = updated_on;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public VendorMapProduct getVendorMapProduct() {
		return vendorMapProduct;
	}

	public void setVendorMapProduct(VendorMapProduct vendorMapProduct) {
		this.vendorMapProduct = vendorMapProduct;
	}
	
	
	
	
}
