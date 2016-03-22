package com.wf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wf.bean.CustomerAddrBean;
import com.wf.bean.Orderaddress;
import com.wf.bean.OrderinfoBean;
import com.wf.bean.OrderinfoStatus;
import com.wf.bean.Simplepojo;
import com.wf.common.DBConnection;
import com.wf.common.SeqUtil;

public class OrderinfoDao {
	public List<OrderinfoBean> selectOrderinfo(int opreaterId) {
		List<OrderinfoBean> list = new ArrayList<OrderinfoBean>();
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select * from orderinfo where operaterId = "
					+ opreaterId + ";";
			ResultSet rs = stat.executeQuery(ms);
			while (rs.next()) {
				int orderId = rs.getInt("orderId");
				int orderType = rs.getInt("orderType");
				String processDept = rs.getString("processDept");
				String channelType = rs.getString("channelType");
				int orderStatus = rs.getInt("orderStatus");
				int custormerId = rs.getInt("custormerId");
				int operaterId = rs.getInt("operaterId");
				Date createTime = rs.getDate("createTime");
				Date lastModifyTime = rs.getDate("lastModifyTime");
				int runNo = rs.getInt("runNo");
				int returnProcessId = rs.getInt("returnProcessId");
				
				OrderinfoBean bran = new OrderinfoBean();
				
				bran.setOrderType(orderType);
				bran.setProcessDept(processDept);
				bran.setChannelType(channelType);
				bran.setOrderStatus(orderStatus);
				bran.setCustormerId(custormerId);
				bran.setOperaterId(operaterId);
				bran.setCreateTime(createTime);
				bran.setLastModifyTime(lastModifyTime);
				bran.setRunNo(runNo);
				bran.setReturnProcessId(returnProcessId);
				list.add(bran);
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
	public List<Simplepojo> selectSimplepojo(int opreaterId,int status){
		List<Simplepojo> list = new ArrayList<Simplepojo>();
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select o.orderId ,o.custormerId,c.isDefault,c.addressId,c.detail from orderinfo  o LEFT JOIN customeraddr c on o.custormerId = c.custormerId   where o.operaterId ="+opreaterId+" and o.orderStatus = "+status+";";
			System.out.println(ms);
			ResultSet rs = stat.executeQuery(ms);
			while(rs.next()){
				int orderId = rs.getInt("orderId");
				int custormerId = rs.getInt("custormerId");
				int addressId = rs.getInt("addressId");
				String isDefault = rs.getString("isDefault");
				String detail = rs.getString("detail");
				
				Simplepojo bean = new Simplepojo();
				bean.setOrderId(orderId);
				bean.setCustormerId(custormerId);
				bean.setAddressId(addressId);
				bean.setIsDefault(isDefault);
				bean.setDetail(detail);
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
		System.out.println(list.size());
		return list;
		
	}
	//增加
	public int insertOrderinfo(OrderinfoBean orderinfo){
		//时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date(System.currentTimeMillis()));
		System.out.println("time="+time);
		
		int nextSeq = SeqUtil.getNextSeq("orderinfo");
		System.out.println("nextSeq="+nextSeq);
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "insert into orderinfo value("+nextSeq+","+orderinfo.getOrderType()+",'"+orderinfo.getProcessDept()+"','"+orderinfo.getChannelType()+"',"
					+ ""+orderinfo.getOrderStatus()+","+orderinfo.getCustormerId()+","+orderinfo.getOperaterId()+",'"+orderinfo.getCreateTime()+"','"+time+"',"+orderinfo.getRunNo()+","+orderinfo.getReturnProcessId()+");";
			System.out.println(ms);
			stat.executeUpdate(ms);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextSeq;
	}
	//修改
	public boolean update0rderFacadeinfo(int orderStatus,int orderId){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date(System.currentTimeMillis()));
		System.out.println("time="+time);
		int i = 0;
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "update orderinfo SET createTime ='"+time+"', orderStatus = "+orderStatus+" WHERE  orderId="+orderId+";";
			 i=stat.executeUpdate(ms);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connectionon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i==0){
			System.out.println("0");
			return false;
		}else{
			System.out.println("1");
			return true;
		}
		
	}
	
	
	public List<Simplepojo> selectPages(int opreaterId,int status,int location){
		List<Simplepojo> list = new ArrayList<Simplepojo>();
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select o.orderId ,o.custormerId,c.isDefault,c.addressId,c.detail from orderinfo  o LEFT JOIN customeraddr c on o.custormerId = c.custormerId   where o.operaterId ="+opreaterId+" and o.orderStatus = "+status+" LIMIT "+location+",5;";
			System.out.println(ms);
			ResultSet rs = stat.executeQuery(ms);
			while(rs.next()){
				int orderId = rs.getInt("orderId");
				int custormerId = rs.getInt("custormerId");
				int addressId = rs.getInt("addressId");
				String isDefault = rs.getString("isDefault");
				String detail = rs.getString("detail");
				
				Simplepojo bean = new Simplepojo();
				bean.setOrderId(orderId);
				bean.setCustormerId(custormerId);
				bean.setAddressId(addressId);
				bean.setIsDefault(isDefault);
				bean.setDetail(detail);
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
	public List<OrderinfoBean> selectOrderinfoBycustormerId(int custormerId) {
		//时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date(System.currentTimeMillis()));
		System.out.println("time="+time);
		
		List<OrderinfoBean> list = new ArrayList<OrderinfoBean>();
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select * from orderinfo where custormerId = "
					+ custormerId + " and orderStatus <> 6;";
			ResultSet rs = stat.executeQuery(ms);
			while (rs.next()) {
				int orderId = rs.getInt("orderId");
				int orderType = rs.getInt("orderType");
				String processDept = rs.getString("processDept");
				String channelType = rs.getString("channelType");
				int orderStatus = rs.getInt("orderStatus");
				int custormerId1 = rs.getInt("custormerId");
				int operaterId = rs.getInt("operaterId");
				Date createTime = rs.getDate("createTime");
//				Date lastModifyTime = rs.getDate("lastModifyTime");
				int runNo = rs.getInt("runNo");
				int returnProcessId = rs.getInt("returnProcessId");
				
				OrderinfoBean bran = new OrderinfoBean();
				
				bran.setOrderId(orderId);
				bran.setOrderType(orderType);
				bran.setProcessDept(processDept);
				bran.setChannelType(channelType);
				bran.setOrderStatus(orderStatus);
				bran.setCustormerId(custormerId1);
				bran.setOperaterId(operaterId);
				bran.setCreateTime(createTime);
				bran.setLastModifyTime(createTime);;
				bran.setRunNo(runNo);
				bran.setReturnProcessId(returnProcessId);
				list.add(bran);
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
	
	public List queryOrderListByCustomerAndStatus(int customerId ,int status)
	{
		List list = new ArrayList();
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select * from orderinfo where custormerId = "
					+ customerId +" and orderStatus = " +status +";";
			ResultSet rs = stat.executeQuery(ms);
			while (rs.next()) {
				int orderId = rs.getInt("orderId");
				
				OrderinfoBean bran = new OrderinfoBean();
				
				bran.setOrderId(orderId);;
				list.add(orderId);
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
	
	public Orderaddress selectOC(int orderId){
		Orderaddress bean = null;		
		Connection connectionon = DBConnection.getConnectionon();
			try {
				Statement stat = connectionon.createStatement();
				String ms = "select o.custormerId ,c.detail from orderinfo  o LEFT JOIN customeraddr c on o.custormerId = c.custormerId   where o.orderId ="+orderId+";";
				System.out.println(ms);
				ResultSet rs = stat.executeQuery(ms);
				while(rs.next()){
					int custormerId = rs.getInt("custormerId");
					String detail = rs.getString("detail");
					
				    bean = new Orderaddress();
					bean.setCustormerId(custormerId);;
					bean.setDetail(detail);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		try {
				connectionon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		System.out.println(bean);
			return bean;
	} 
	
	public int update0rderFactoryinfo(int orderId, int operaterId,int orderStatus){
		int s = 0;
		Connection connectionon = DBConnection.getConnectionon();
			try {
				Statement stat = connectionon.createStatement();
				String ms = "update  orderinfo set operaterId="+operaterId+",orderStatus = "+orderStatus+" where orderId="+orderId+";";
				 s=stat.executeUpdate(ms);
				System.out.println(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connectionon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
	}
	public List<OrderinfoStatus> selectOF(int orderStatus){
		List<OrderinfoStatus> list = new ArrayList<OrderinfoStatus>();
		Connection connectionon = DBConnection.getConnectionon();
			try {
				Statement stat = connectionon.createStatement();
				String ms = "select o.orderStatus ,o.orderId,f.address from orderinfo  o LEFT JOIN facade f on o.operaterId = f.operaterId   where orderStatus ="+orderStatus+";";
				ResultSet rs=stat.executeQuery(ms);
				while(rs.next()){
					int orderStatus1 = rs.getInt("orderStatus");
					int orderId = rs.getInt("orderId");
					String address = rs.getString("address");
					
					OrderinfoStatus bean = new OrderinfoStatus();
					bean.setOrderStatus(orderStatus1);
					bean.setOrderId(orderId);
					bean.setAddress(address);
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
	
	public List<OrderinfoStatus> selectOFPages(int status,int location){
		List<OrderinfoStatus> list = new ArrayList<OrderinfoStatus>();
		Connection connectionon = DBConnection.getConnectionon();
			try {
				Statement stat = connectionon.createStatement();
				String ms = "select o.orderStatus ,o.orderId,f.address from orderinfo  o LEFT JOIN facade f on o.operaterId = f.operaterId   where  o.orderStatus = "+status+" LIMIT "+location+",5;";
				ResultSet rs=stat.executeQuery(ms);
				while(rs.next()){
					int orderStatus1 = rs.getInt("orderStatus");
					int orderId = rs.getInt("orderId");
					String address = rs.getString("address");
					
					OrderinfoStatus bean = new OrderinfoStatus();
					bean.setOrderStatus(orderStatus1);
					bean.setOrderId(orderId);
					bean.setAddress(address);
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
			try {
				connectionon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list.size());
			return list;
	}
	public List<Simplepojo> selectSimplepojo(int status){
		List<Simplepojo> list = new ArrayList<Simplepojo>();
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select o.orderId ,o.custormerId,c.isDefault,c.addressId,c.detail from orderinfo  o LEFT JOIN customeraddr c on o.custormerId = c.custormerId   where o.orderStatus = "+status+";";
			ResultSet rs = stat.executeQuery(ms);
			while(rs.next()){
				int orderId = rs.getInt("orderId");
				int custormerId = rs.getInt("custormerId");
				int addressId = rs.getInt("addressId");
				String isDefault = rs.getString("isDefault");
				String detail = rs.getString("detail");
				
				Simplepojo bean = new Simplepojo();
				bean.setOrderId(orderId);
				bean.setCustormerId(custormerId);
				bean.setAddressId(addressId);
				bean.setIsDefault(isDefault);
				bean.setDetail(detail);
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
	public List<Simplepojo> selectPages(int status,int location){
		List<Simplepojo> list = new ArrayList<Simplepojo>();
		Connection connectionon = DBConnection.getConnectionon();
		try {
			Statement stat = connectionon.createStatement();
			String ms = "select o.orderId ,o.custormerId,c.isDefault,c.addressId,c.detail from orderinfo  o LEFT JOIN customeraddr c on o.custormerId = c.custormerId   where  o.orderStatus = "+status+" LIMIT "+location+",5;";
			System.out.println(ms);
			ResultSet rs = stat.executeQuery(ms);
			while(rs.next()){
				int orderId = rs.getInt("orderId");
				int custormerId = rs.getInt("custormerId");
				int addressId = rs.getInt("addressId");
				String isDefault = rs.getString("isDefault");
				String detail = rs.getString("detail");
				
				Simplepojo bean = new Simplepojo();
				bean.setOrderId(orderId);
				bean.setCustormerId(custormerId);
				bean.setAddressId(addressId);
				bean.setIsDefault(isDefault);
				bean.setDetail(detail);
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
