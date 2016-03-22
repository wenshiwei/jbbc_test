package com.wf.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeqUtil {
	public static int getNextSeq(String sqlName)
	{
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement createStatement = connectionon.createStatement();
			System.out.println("SELECT NEXTVAL('"+sqlName+ "') SEQ");
			ResultSet executeQuery = createStatement.executeQuery("SELECT NEXTVAL('"+sqlName + "') SEQ");
			executeQuery.next();
			int seq = executeQuery.getInt("SEQ");
			System.out.println(seq);
			return seq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
