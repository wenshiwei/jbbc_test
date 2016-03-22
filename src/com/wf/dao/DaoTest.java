package com.wf.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.wf.bean.CustomerBean;
import com.wf.bean.OrderinfoBean;
import com.wf.bean.Simplepojo;
import com.wf.common.DBConnection;
import com.wf.common.SeqUtil;

public class DaoTest {

	public static void main(String[] args) {
		
		init();
		
		
		testClothesDao();
	}

	private static void testClothesDao() {
//		CustomerDao customerDao = new CustomerDao();
//		CustomerBean byCustomerId = customerDao.ByCustomerId("1");
//		System.out.println(byCustomerId);
		
		
		OrderinfoDao dao= new OrderinfoDao();
		dao.update0rderFacadeinfo(2, 2);
//		ArrayList<Simplepojo> list=(ArrayList<Simplepojo>) dao.selectSimplepojo(1, 1);
//		System.out.println(list.size());
//		dao.update0rderinfo(4, 1);
//		ArrayList<Simplepojo> list=(ArrayList<Simplepojo>) dao.selectPages(1, 1, 1);
//		System.out.println(list.size());
//		dao.selectOC(1);
//		dao.update0rderFacadeinfo(1, 5, 5);
//		dao.selectOFPages(1, 1, 1);
//		dao.selectSimplepojo(2, 0);
//		int nextSeq = SeqUtil.getNextSeq("orderinfo");
//		System.out.println("nextSeq="+nextSeq);
//		
		
		
//		OrderinfoBean bean = new OrderinfoBean();
//		
//		bean.setChannelType("o");
//		Date time = new Date(System.currentTimeMillis());
//		bean.setCreateTime(time);
//		bean.setCustormerId(1);
//		int s=dao.insertOrderinfo(bean);
//		System.out.println(s);
		
//		NoticeDao nd = new NoticeDao();
//		nd.selectContentByTitle("");
		
//		ClothesDao cd= new ClothesDao();
//		cd.insertClothes(null);
		
//		FacadeDao dao = new FacadeDao();
//		dao.selectFacade();
//		Dao dao = new Dao();
//		dao.selectDao(1, 1);
	}

	private static void init() {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.148:3306/washfactory?user=root&password=hxserver&useUnicode=true&characterEncoding=UTF-8";
		DBConnection.init(driver, url);
	}
}
