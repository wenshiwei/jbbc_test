package com.wf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wf.bean.OperatorBean;
import com.wf.common.DBConnection;

public class OperatorDao {
	public OperatorBean checkOprLogin(int loginId, int type) {
		Connection connectionon = DBConnection.getConnectionon();

		System.out.println("loginId="+loginId+"//////////"+"type==="+type);
		OperatorBean bean = null;
		try {

			Statement stat = connectionon.createStatement();
			// ≤È—Ø
			String ms = "select * from operator where type= " + type
					+ " and loginId= " + loginId + " ;";
			ResultSet rs = stat.executeQuery(ms);
			while (rs.next()) {
				int operatorId = rs.getInt("operatorId");
				int type1 = rs.getInt("type");
				String name = rs.getString("name");
				int loginId1 = rs.getInt("loginId");
				String password = rs.getString("password");

				bean = new OperatorBean();
				bean.setOperatorId(operatorId);
				bean.setType(type1);
				bean.setName(name);
				bean.setLoginId(loginId1);
				bean.setPassword(password);

				return bean;
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
		return bean;
	}

}
