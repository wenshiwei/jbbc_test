package com.wf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wf.bean.Bean;
import com.wf.common.DBConnection;

public class Dao {
	
	List<Bean>  list = new ArrayList<Bean>();
	
	public List<Bean> selectDao(int custormerId,int orderStatus,int currentPage){
		
			try {
				Connection connectionon = DBConnection.getConnectionon();
				Statement stat1 = connectionon.createStatement();
				String ms ="select o.orderId,o.createTime,o.lastModifyTime,"
						+ "cc.number from orderinfo o LEFT JOIN (select orderId, SUM(c.clothesNumber) number "
						+ "from clothes c GROUP BY c.orderId) cc on o.orderId = cc.orderId  "
						+ "where o.custormerId = "+custormerId+" and o.orderStatus = "+orderStatus+" LIMIT "+((currentPage-1)*7)+",7;";
				ResultSet  rs = stat1.executeQuery(ms);
				while (rs.next()) {
					Date createTime = rs.getDate("createTime");
					int orderId = rs.getInt("orderId");
					int number = rs.getInt("number");
					Date lastModifyTime = rs.getDate("lastModifyTime");
					
					Bean bean = new Bean();
					bean.setCreateTime(createTime);
					bean.setOrderId(orderId);
					bean.setNumber(number);
					bean.setLastModifyTime(lastModifyTime);
					
					list.add(bean);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    return list;
		
	}
	
//	public List<Bean> selectPage(int custormerId,int orderStatus,int currentPage){
//		try {
//			Connection connectionon = DBConnection.getConnectionon();
//			Statement stat2 = connectionon.createStatement();
//			String ms ="select o.orderId,o.createTime,o.lastModifyTime,"
//					+ "cc.number from orderinfo o LEFT JOIN (select orderId, SUM(c.clothesNumber) number "
//					+ "from clothes c GROUP BY c.orderId) cc on o.orderId = cc.orderId  "
//					+ "where o.custormerId = "+custormerId+" and o.orderStatus = "+orderStatus+";";
//			ResultSet  rs = stat2.executeQuery(ms);
//			while (rs.next()) {
//				Date createTime = rs.getDate("createTime");
//				int orderId = rs.getInt("orderId");
//				int number = rs.getInt("number");
//				Date lastModifyTime = rs.getDate("lastModifyTime");
//				
//				Bean bean = new Bean();
//				bean.setCreateTime(createTime);
//				bean.setOrderId(orderId);
//				bean.setNumber(number);
//				bean.setLastModifyTime(lastModifyTime);
//				
//				list.add(bean);
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(list.size());
//		return list;
//	}

}
