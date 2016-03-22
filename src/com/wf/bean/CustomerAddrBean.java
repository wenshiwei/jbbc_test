package com.wf.bean;

public class CustomerAddrBean {
	int addressId;
	int custormerId;
	String isDefault;
	String detail;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getCustormerId() {
		return custormerId;
	}

	public void setCustormerId(int custormerId) {
		this.custormerId = custormerId;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
