package com.wf.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.CustomerBean;
import com.wf.bean.OrderinfoBean;
import com.wf.dao.CustomerDao;
import com.wf.dao.OrderinfoDao;

/**
 * Servlet implementation class OrderinfoServlet
 */
public class OrderinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderinfoServlet() {
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
		String count = request.getParameter("clothesCount");
		int c = Integer.parseInt(count);
		
		Date time = new Date(System.currentTimeMillis());
		String loginId = request.getParameter("username");
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
		request.getSession().setAttribute("message", message);
		request.getSession().setAttribute("clothesCount", c);
		request.getSession().setAttribute("orderId", orderId);
		request.getSession().setAttribute("custormerId", custormerId);
		request.getRequestDispatcher("OtoChannelServlet").forward(request, response);

		
	}

}
