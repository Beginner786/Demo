package com.example.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="invoice_main", uniqueConstraints=
@UniqueConstraint(columnNames={"invoice_id"}))
public class InvoiceMain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="invoice_item_id")
	private Long id;
	
	@Column(name="invoice_id")
	private String invoice_id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="invoice_id_one_to_one")
	private InvoiceHead invoiceHead;
	
	@Column(name="unit_price")
	private Double unit_price;
	
	@Column(name="product_id")
	private String product_id;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="created_on")
	private Timestamp created_on;
	
	@Column(name="updated_by")
	private String updated_by;
	
	@Column(name="updated_on")
	private Timestamp updated_on;
	
	public InvoiceMain() {}

	public InvoiceMain(String invoice_id, Double unit_price, String product_id) {
		super();
		this.invoice_id = invoice_id;
		this.unit_price = unit_price;
		this.product_id = product_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}

	public InvoiceHead getInvoiceHead() {
		return invoiceHead;
	}

	public void setInvoiceHead(InvoiceHead invoiceHead) {
		this.invoiceHead = invoiceHead;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public Timestamp getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Timestamp updated_on) {
		this.updated_on = updated_on;
	}
	
	
	
	
}
