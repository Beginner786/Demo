package com.example.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="vendor" , uniqueConstraints=
	@UniqueConstraint(columnNames={"vendor_id"})
)
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="vendor_id")
	private String vendor_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="added_on")
	private Timestamp added_on;
	
	@Column(name="added_by")
	private String added_by;
	
	@Column(name="updated_on")
	private Timestamp updated_on;
	
	@Column(name="updated_by")
	private String updated_by;
	
	public Vendor() {}

	public Vendor(String vendor_id, String name, String address) {
		super();
		this.vendor_id = vendor_id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	
	
	
}
