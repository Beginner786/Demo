package com.example.model;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="purchase_order_main", uniqueConstraints=
@UniqueConstraint(columnNames={"purchase_order_id"})
)
public class PurchaseOrderMain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="purchase_item_id")
	private Long purchase_item_id;
	
	@Column(name="purchase_order_id")
	private String purchase_order_id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="purchase_order_id_one_to_one")
	private PurchaseOrderHead purchaseOrderHead;
	
	@Column(name="product_id")
	private String product_id;
	
	@Column(name="unit_price")
	private Double unit_price;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="created_on")
	private Timestamp created_on;
	
	@Column(name="updated_by")
	private String updated_by;
	
	@Column(name="updated_on")
	private Timestamp updated_on;

	public PurchaseOrderMain() {}

	public PurchaseOrderMain(String purchase_order_id, String product_id, Double unit_price) {
		super();
		this.purchase_order_id = purchase_order_id;
		this.product_id = product_id;
		this.unit_price = unit_price;
	}

	public Long getPurchase_item_id() {
		return purchase_item_id;
	}

	public void setPurchase_item_id(Long purchase_item_id) {
		this.purchase_item_id = purchase_item_id;
	}

	public String getPurchase_order_id() {
		return purchase_order_id;
	}

	public void setPurchase_order_id(String purchase_order_id) {
		this.purchase_order_id = purchase_order_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
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

	public PurchaseOrderHead getPurchaseOrderHead() {
		return purchaseOrderHead;
	}

	public void setPurchaseOrderHead(PurchaseOrderHead purchaseOrderHead) {
		this.purchaseOrderHead = purchaseOrderHead;
	}

	
	
	
	
}
