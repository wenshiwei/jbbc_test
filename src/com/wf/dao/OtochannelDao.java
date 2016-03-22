package com.wf.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.wf.bean.OtochannelBean;
import com.wf.common.DBConnection;
import com.wf.common.SeqUtil;

public class OtochannelDao {
	public int insertOtochannel(OtochannelBean otochannel){
		int nextSeq = SeqUtil.getNextSeq("otochannel");
		System.out.println("nextSeq="+nextSeq);
		Connection connectionon = DBConnection.getConnectionon();
		
		try {
			Statement stat = connectionon.createStatement();
			String ms = "insert into otochannel value("+nextSeq+","+otochannel.getCustormerId()+","+otochannel.getOperaterOd()+","+otochannel.getOrderId()+","+otochannel.getCount()+",'"+otochannel.getMessage()+"');";
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
		return nextSeq;
	}

}
