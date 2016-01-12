package com.gofynd.bean;

public class ItemSizeQuantity {
	
	
	private int sizeId;
	private int quantity;
	private int id;
	private int stockId;

	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ItemSizeQuantity(int stockId, int sizeId, int quantity) {
		super();
		this.stockId = stockId;
		this.sizeId = sizeId;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
}
