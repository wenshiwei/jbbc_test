package com.wf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.wf.bean.CustomerBean;
import com.wf.bean.OperatorBean;
import com.wf.common.DBConnection;
import com.wf.common.SeqUtil;

public class CustomerDao {
	public int insertCustomer(CustomerBean customer) {
		// ��ȡ��ǰϵͳʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date(System.currentTimeMillis()));
		System.out.println("time="+time);
		int nextSeq = SeqUtil.getNextSeq("customer");
		System.out.println("nextSeq="+nextSeq);
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			// ����
			String ms = "insert into customer value(" + nextSeq + ",'"
					+ customer.getTelNumber() + "','" + customer.getTelName()
					+ "','" + time + "','" + customer.getLoginId() + "','"
					+ customer.getPassword() + "');";
			System.out.println(ms);
			stat.executeUpdate(ms); // ִ��MySql���
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nextSeq;
	}

	//客户完成订单中的分页
	public int queryPageCount(){
		int count = 0;
		Connection connectionon = DBConnection.getConnectionon();
		Statement stat;
		try {
			stat = connectionon.createStatement();
			String sql = "select count(*) custormerId from orderinfo;";
			ResultSet executeQuery = stat.executeQuery(sql);
			executeQuery.next();
			count = executeQuery.getInt("custormerId");
			int y = count % 7;
			count = count / 7;
			count = y == 0 ? count : count + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public CustomerBean ByCustomerId(String loginId) {
		CustomerBean cust = null;
		Connection connectionon = DBConnection.getConnectionon();

		try {
			Statement stat = connectionon.createStatement();
			String ms = "select * from customer where loginId = '" + loginId
					+ "';";
			ResultSet rs = stat.executeQuery(ms);
			while (rs.next()) {
				int custormerId = rs.getInt("custormerId");
				String telNumber = rs.getString("telNumber");
				String telName = rs.getString("telName");
				Date createTime = rs.getDate("createTime");
				String loginId1 = rs.getString("loginId");
				String password = rs.getString("password");

				cust = new CustomerBean();
				cust.setCustormerId(custormerId);
				cust.setTelNumber(telNumber);
				cust.setTelName(telName);
				cust.setCreateTime(createTime);
				cust.setLoginId(loginId1);
				cust.setPassword(password);
				return cust;
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
		return null;
	}

}
