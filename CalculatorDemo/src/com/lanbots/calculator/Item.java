package com.lanbots.calculator;

public class Item {
	
	public double value;
	public int type;
	
	public Item(double value , int type){
		this.value = value;
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	

}
