package com.gofynd.bean;

public class Stock 
{
	private int stockId;
	private int itemId;
	private int shadeId;
	private double mrp;
	
	public Stock()
	{
		
	}
	public Stock(int itemId, int shadeId, double mrp) {
		super();
		this.itemId = itemId;
		this.shadeId = shadeId;
		this.mrp = mrp;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getShadeId() {
		return shadeId;
	}
	public void setShadeId(int shadeId) {
		this.shadeId = shadeId;
	}

	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
}
