package com.wf.bean;

import java.sql.Date;

public class OrderinfoBean {
	int orderId;
	int orderType;
	String processDept;
	String channelType;
	int orderStatus;
	int custormerId;
	int operaterId;
	Date createTime;
	Date lastModifyTime;
	int runNo;
	int returnProcessId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getProcessDept() {
		return processDept;
	}

	public void setProcessDept(String processDept) {
		this.processDept = processDept;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getCustormerId() {
		return custormerId;
	}

	public void setCustormerId(int custormerId) {
		this.custormerId = custormerId;
	}

	public int getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(int operaterId) {
		this.operaterId = operaterId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public int getRunNo() {
		return runNo;
	}

	public void setRunNo(int runNo) {
		this.runNo = runNo;
	}

	public int getReturnProcessId() {
		return returnProcessId;
	}

	public void setReturnProcessId(int returnProcessId) {
		this.returnProcessId = returnProcessId;
	}

}
