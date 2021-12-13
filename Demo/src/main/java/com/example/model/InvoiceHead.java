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
@Table(name="invoice_head", uniqueConstraints=
@UniqueConstraint(columnNames={"invoice_id"}))
public class InvoiceHead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="invoice_id")
	private String invoice_id;
	
	@Column(name="purchase_order_id")
	private String purchase_order_id;
	
	@Column(name="tot_quantity_received")
	private Long tot_quantity_received;
	
	@Column(name="total_price")
	private Double total_price;
	
	@Column(name="received_on")
	private String received_on;
	
	@Column(name="status")
	private int status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="status_many_to_one")
	private Status status_obj;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="created_on")
	private Timestamp created_on;
	
	@Column(name="updated_by")
	private String updated_by;
	
	@Column(name="updated_on")
	private Timestamp updated_on;
	
	
	public InvoiceHead() {}


	public InvoiceHead(String purchase_order_id, Long tot_quantity_received,
			String received_on) {
		super();
		this.purchase_order_id = purchase_order_id;
		this.tot_quantity_received = tot_quantity_received;
		this.received_on = received_on;
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


	public String getPurchase_order_id() {
		return purchase_order_id;
	}


	public void setPurchase_order_id(String purchase_order_id) {
		this.purchase_order_id = purchase_order_id;
	}


	public Long getTot_quantity_received() {
		return tot_quantity_received;
	}


	public void setTot_quantity_received(Long tot_quantity_received) {
		this.tot_quantity_received = tot_quantity_received;
	}


	public Double getTotal_price() {
		return total_price;
	}


	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}


	public String getReceived_on() {
		return received_on;
	}


	public void setReceived_on(String received_on) {
		this.received_on = received_on;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Status getStatus_obj() {
		return status_obj;
	}


	public void setStatus_obj(Status status_obj) {
		this.status_obj = status_obj;
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
