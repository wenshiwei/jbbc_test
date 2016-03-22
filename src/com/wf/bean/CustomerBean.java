package com.wf.bean;

import java.util.Date;

public class CustomerBean {
	int custormerId;
	String telNumber;
	String telName;
	Date createTime;
	String loginId;
	String password;

	public int getCustormerId() {
		return custormerId;
	}

	public void setCustormerId(int custormerId) {
		this.custormerId = custormerId;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getTelName() {
		return telName;
	}

	public void setTelName(String telName) {
		this.telName = telName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
