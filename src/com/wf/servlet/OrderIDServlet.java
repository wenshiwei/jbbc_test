package com.wf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.FacadeBean;
import com.wf.dao.FacadeDao;
import com.wf.dao.OrderinfoDao;

/**
 * 保存订单ID的servlet
 * 
 * @author 张凌铭
 *
 */
public class OrderIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderIDServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int OrderID = Integer.valueOf(request.getParameter("OrderID"));
		
		request.getSession().setAttribute("OrderID", OrderID);
		int status=Integer.valueOf(request.getParameter("Status"));
		if(status==0){
			//根据订单ID查询订单地址
			OrderinfoDao qurreyOrderAddrres=new OrderinfoDao();
			String orderAddress =qurreyOrderAddrres.selectOC(OrderID).getDetail();
			//将地址设置到Session中
			request.getSession().setAttribute("OrderAddress", orderAddress);
			/****************操作数据库***********************/
			FacadeDao facadeData=new FacadeDao();
			ArrayList<FacadeBean> listFacadeData= (ArrayList<FacadeBean>) facadeData.selectFacade();
			/************返回一个该操作员的门店对象的队列***************/
			request.getSession().setAttribute("listFacadeData", listFacadeData);
			response.sendRedirect("zhipaimessage.jsp");	
		}
		if(status==1){
		response.sendRedirect("clothes.jsp");
		}
	}

}
