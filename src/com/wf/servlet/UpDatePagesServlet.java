package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于上下页切换时处理当前页和跳转的Servlet
 */
public class UpDatePagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpDatePagesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//上下页调换时，获取将要调换到的页数，并且根据状态跳到指定的数据查询的Servlet
		int NowPage = Integer.valueOf(request.getParameter("NowPage"));
		int status = Integer.valueOf(request.getParameter("Status"));
		//将 要跳转到的页面设置到Session中方便查询数据时的获取
		request.getSession().setAttribute("nowPages", NowPage);
		if (status == 1) {
			response.sendRedirect("FacadeServlet?Status=" + status);
		} else if (status == 2) {
			response.sendRedirect("FdeOrderDealServlet?Status=" + status);
		} else if (status == 3) {
			response.sendRedirect("FdeOrderSendServlet?Status=" + status);
		}
	}

}
