package com.gofynd.bean;

import java.util.List;

public class ItemToDisplay {
	private String itemName;
	private String shadeName;
	private double mrp;
	private List<SizeQuantityDisplay> list;
	public ItemToDisplay(String itemName, String shadeName, double mrp) {
		super();
		this.itemName = itemName;
		this.shadeName = shadeName;
		this.mrp = mrp;
	}
	public ItemToDisplay()
	{
		
	}
	public List<SizeQuantityDisplay> getList() {
		return list;
	}
	public void setList(List<SizeQuantityDisplay> list) {
		this.list = list;
	}
	public String getItemName() {
		return itemName;
	}
	public String getShadeName() {
		return shadeName;
	}
	public void setShadeName(String shadeName) {
		this.shadeName = shadeName;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	
	
}
