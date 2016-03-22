package com.wf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wf.bean.PriceBean;
import com.wf.common.DBConnection;

public class PriceDao {
	
	public int queryPageCount(){
		int count = 0;
		Connection connectionon = DBConnection.getConnectionon();
		Statement stat;
		try {
			stat = connectionon.createStatement();
			String sql = "select count(*) priceId from price";
			ResultSet executeQuery = stat.executeQuery(sql);
			executeQuery.next();
			count = executeQuery.getInt("priceId");
			int y = count % 8;
			count = count / 8;
			count = y == 0 ? count : count + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	int pageNo = 8;
	public List<PriceBean> queryByPageIndex(int pageIndex){
		List<PriceBean> list = new ArrayList<PriceBean>();
		
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			int startIndex = (pageIndex-1)*pageNo;
			String ms = "select * from price limit "+startIndex+", "+pageNo;
			
			ResultSet rs = stat.executeQuery(ms);
			while(rs.next()){
				int priceId = rs.getInt("priceId");
				String clothesType = rs.getString("clothesType");
				String clothesLevel = rs.getString("clothesLevel");
				int charge = rs.getInt("charge");
				String imageUrl = rs.getString("imageUrl");
				
				PriceBean bean = new PriceBean();
				bean.setPriceId(priceId);
				bean.setClothesType(clothesType);
				bean.setClothesLevel(clothesLevel);
				bean.setCharge(charge);
				bean.setImageUrl(imageUrl);
				list.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	

}
