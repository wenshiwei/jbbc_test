package com.wf.bean;

public class Orderaddress {
	int custormerId;
	String detail;
	public int getCustormerId() {
		return custormerId;
	}
	public void setCustormerId(int custormerId) {
		this.custormerId = custormerId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Orderaddress [custormerId=" + custormerId + ", detail="
				+ detail + "]";
	}
	
	
	
}
