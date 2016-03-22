package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 从左边打开订单状态时设置默认当前页为第一页
 * 
 * @author 张凌铭
 *
 */
public class OpenOrderPagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpenOrderPagServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 是从左边超链接跳入
		// 设置默认的当前页数为第一页
		request.getSession().setAttribute("nowPages", 1);
		// 获取订单状态
		int status = Integer.valueOf(request.getParameter("Status"));
		if (status == 1) {
			response.sendRedirect("FacadeServlet?Status=" + status);
		} else if (status == 2) {
			response.sendRedirect("FdeOrderDealServlet?Status=" + status);
		} else if (status == 5) {
			response.sendRedirect("FdeOrderSendServlet?Status=" + status);
		}else if(status==0){
			response.sendRedirect("FactoryServlet?Status=" + status);
		}
		else if(status==3){
			response.sendRedirect("FactoryDrderDealServlet?Status=" + status);
		}
		else if(status==4){
			response.sendRedirect("FactoryOrderSendServlet?Status=" + status);
		}
	}

}
