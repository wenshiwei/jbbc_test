package com.wf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wf.bean.FacadeBean;
import com.wf.bean.Orderaddress;
import com.wf.common.DBConnection;

public class FacadeDao {
	public List<FacadeBean> selectFacade(){
		List<FacadeBean> list = new ArrayList<FacadeBean>();
    Connection connectionon = DBConnection.getConnectionon();
		
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select * from facade;";
			ResultSet rs = stat.executeQuery(ms);
			while(rs.next()){
				int facadeId = rs.getInt("facadeId");
				String address = rs.getString("address");
				int operaterId1 = rs.getInt("operaterId");
				
				FacadeBean bean = new FacadeBean();
				bean.setFacadeId(facadeId);
				bean.setAddress(address);
				bean.setOperaterId(operaterId1);
				list.add(bean);
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
		System.out.println(list.size());
		return list;
	}

}
