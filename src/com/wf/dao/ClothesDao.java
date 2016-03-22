package com.wf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wf.bean.ClothesBean;
import com.wf.common.DBConnection;
import com.wf.common.SeqUtil;

public class ClothesDao {
	public int insertClothes(ClothesBean clothes) {
		int nextSeq = SeqUtil.getNextSeq("clothes");
		System.out.println("nextSeq="+nextSeq);
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = " insert into clothes value("+nextSeq+","+clothes.getOrderId()+",'"
					+clothes.getClothesType()+ "','"+clothes.getClothesLevel()+"','"+clothes.getDescription()+"',"+clothes.getClothesNumber()+");";
			stat.executeUpdate(ms);
			System.out.println(ms);
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
	
	public int queryClothesCountByOrderId(int orderId)
	{
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select SUM(clothesNumber) ct from clothes where orderid = " +orderId +  " ;";
			ResultSet executeQuery = stat.executeQuery(ms);
			executeQuery.next();
			int ct = executeQuery.getInt("ct");
			return ct;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
