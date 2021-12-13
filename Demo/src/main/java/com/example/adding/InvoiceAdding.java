package com.example.adding;


public class InvoiceAdding {
	
	private String purchaseOId;
	private Long totalQuantityReceived;
	private String receivedOn;
	private Double unitPrice;
	private String productId;
	
	public InvoiceAdding() {}
	
	public InvoiceAdding(String purchaseOId, Long totalQuantityReceived, String receivedOn, Double unitPrice,
			String productId) {
		super();
		this.purchaseOId = purchaseOId;
		this.totalQuantityReceived = totalQuantityReceived;
		this.receivedOn = receivedOn;
		this.unitPrice = unitPrice;
		this.productId = productId;
	}
	
	public String getPurchaseOId() {
		return purchaseOId;
	}
	
	public void setPurchaseOId(String purchaseOId) {
		this.purchaseOId = purchaseOId;
	}
	
	public Long getTotalQuantityReceived() {
		return totalQuantityReceived;
	}
	
	public void setTotalQuantityReceived(Long totalQuantityReceived) {
		this.totalQuantityReceived = totalQuantityReceived;
	}
	
	public String getReceivedOn() {
		return receivedOn;
	}
	
	public void setString(String receivedOn) {
		this.receivedOn = receivedOn;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setReceivedOn(String receivedOn) {
		this.receivedOn = receivedOn;
	}
	
	
	
}
