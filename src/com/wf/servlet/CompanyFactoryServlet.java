package com.wf.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.CustomerBean;
import com.wf.bean.OrderinfoBean;
import com.wf.dao.CustomerDao;
import com.wf.dao.OrderinfoDao;

/**
 * Servlet implementation class CompanyFactoryServlet
 */
public class CompanyFactoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyFactoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		Date time = new Date(System.currentTimeMillis());
		String loginId = request.getParameter("username1");
		System.out.println("loginId="+loginId);
		CustomerDao custDao = new CustomerDao();
		CustomerBean custBean = custDao.ByCustomerId(loginId);
		int custormerId = custBean.getCustormerId();
		OrderinfoDao dao = new OrderinfoDao();
		OrderinfoBean bean = new OrderinfoBean();
		bean.setOrderType(1);
		bean.setChannelType("0");
		bean.setOrderStatus(0);
		bean.setCustormerId(custormerId);
		bean.setCreateTime(time);
		int orderId = dao.insertOrderinfo(bean);
		request.getSession().setAttribute("companyId", loginId);
		response.sendRedirect("promotion_jsp.jsp");
	}

}
