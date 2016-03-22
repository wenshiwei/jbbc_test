package com.wf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wf.bean.NoticeBean;
import com.wf.common.DBConnection;

public class NoticeDao {
	int noticeId=1;
	public List<NoticeBean> selectNotice(){
		List<NoticeBean> list = new ArrayList<NoticeBean>();
		
		Connection connectionon = DBConnection.getConnectionon();
		
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select * from notice;";
			ResultSet rs = stat.executeQuery(ms);
			while(rs.next()){
			int noticeId1 =	rs.getInt("noticeId");
			String title = rs.getString("title");
			String content = rs.getString("content");
			Date createTime = rs.getDate("createTime");
			
			NoticeBean bean = new NoticeBean();
			bean.setNoticeId(noticeId1);
			bean.setTitle(title);
			bean.setContent(content);
			bean.setCreateTime(createTime);
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
		return list;
		
	}
	
	public String selectContentByTitle(String title){
		Connection connectionon = DBConnection.getConnectionon();
		
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select content from notice where title = '"+title+"';";
			ResultSet rs = stat.executeQuery(ms);
			while(rs.next()){
				String content = rs.getString("content");
				return content;
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
