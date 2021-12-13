package com.example.adding;

public class ProductAdding {

	private String product_id;
	private String name;
	private Double unit_price;
	private String vendor_id;
	private String description;
	
	public ProductAdding() {}

	public ProductAdding(String product_id, String name, Double unit_price, String vendor_id, String description) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.unit_price = unit_price;
		this.vendor_id = vendor_id;
		this.description = description;
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

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
