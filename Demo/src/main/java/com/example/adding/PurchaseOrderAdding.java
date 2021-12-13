package com.example.adding;

public class PurchaseOrderAdding {

	private String vendorId;
	private Long totQuantity;
	private String productId;
	private String POId;
	
	public PurchaseOrderAdding() {}

	public PurchaseOrderAdding(String vendorId, Long totQuantity, String productId) {
		super();
		this.vendorId = vendorId;
		this.totQuantity = totQuantity;
		this.productId = productId;
	}
		

	public PurchaseOrderAdding(String vendorId, Long totQuantity, String productId, String pOId) {
		super();
		this.vendorId = vendorId;
		this.totQuantity = totQuantity;
		this.productId = productId;
		this.POId = pOId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public Long getTotQuantity() {
		return totQuantity;
	}

	public void setTotQuantity(Long totQuantity) {
		this.totQuantity = totQuantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPOId() {
		return POId;
	}

	public void setPOId(String pOId) {
		POId = pOId;
	}
	
	
	
	
}
