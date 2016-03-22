package com.wf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wf.bean.CustomerAddrBean;
import com.wf.common.DBConnection;
import com.wf.common.SeqUtil;

public class CustomerAddrDao {

	public CustomerAddrBean insertCustomerAddrByCustomerId(CustomerAddrBean bean) {
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			int nextSeq = SeqUtil.getNextSeq("customerAddr");
			String ms = "insert into customeraddr value("+nextSeq+","+bean.getCustormerId()+",'"
					+bean.getIsDefault()+"','"+bean.getDetail()+"');";
			System.out.println(ms);
			stat.executeUpdate(ms);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
	public String selectDetailByAddressId(int custormerId){
		String detail = null;
		Connection connectionon = DBConnection.getConnectionon();
		
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select detail from customeraddr where custormerId = "+custormerId+";";
			 ResultSet rs = stat.executeQuery(ms);
			 while(rs.next()){
				 detail = rs.getString("detail");
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return detail;
		
	}
	
	public void updateDetailByCustomerId(int customerId,String detail)
	{
		Connection connectionon = DBConnection.getConnectionon();
		
		try {
			Statement stat = connectionon.createStatement();
			String ms = "update customeraddr c set c.detail = '"+detail+"' where custormerId = "+customerId+";";
			 stat.executeUpdate(ms);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
