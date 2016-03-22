package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.dao.OrderinfoDao;

/**
 * 修改数据库中订单表的订单状态
 * 
 * @author 张凌铭
 *
 */

public class UpdaOrderStaeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdaOrderStaeServlet() {
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
		// 获取登记衣服后的订单号，根据订单号来修改该订单的状态。
		int OrderID = (Integer) request.getSession().getAttribute("OrderID");
		int operatorId=(Integer) request.getSession().getAttribute("operatorId");
		
		/********************** 操作数据库 ****************/
		OrderinfoDao facadeDao = new OrderinfoDao();
		
		/*****************根据操作员ID来修改对象表中的订单状态****************/
		//门店操作员
		// 返回插入的状态
		boolean upstate = facadeDao.update0rderFacadeinfo(2, OrderID);

		/************ 数据库修改成功后跳转到默认第一种状态 *******************/

		response.sendRedirect("FacadeServlet?Status=1");
	}

}
