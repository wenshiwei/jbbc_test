package com.wf.bean;

public class ClothesBean {
	int clothesId;
	int orderId;
	String clothesType;
	String clothesLevel;
	String description;
	int clothesNumber;

	public int getClothesId() {
		return clothesId;
	}

	public ClothesBean(int orderId, String clothesType, String clothesLevel, String description, int clothesNumber) {
		super();
		this.orderId = orderId;
		this.clothesType = clothesType;
		this.clothesLevel = clothesLevel;
		this.description = description;
		this.clothesNumber = clothesNumber;
	}

	public void setClothesId(int clothesId) {
		this.clothesId = clothesId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getClothesType() {
		return clothesType;
	}

	public void setClothesType(String clothesType) {
		this.clothesType = clothesType;
	}

	public String getClothesLevel() {
		return clothesLevel;
	}

	public void setClothesLevel(String clothesLevel) {
		this.clothesLevel = clothesLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getClothesNumber() {
		return clothesNumber;
	}

	public void setClothesNumber(int clothesNumber) {
		this.clothesNumber = clothesNumber;
	}

}
