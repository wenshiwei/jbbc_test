package com.wf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.CustomerBean;
import com.wf.bean.OrderinfoBean;
import com.wf.dao.CustomerAddrDao;
import com.wf.dao.CustomerDao;
import com.wf.dao.OrderinfoDao;

/**
 * Servlet implementation class BouoCustServlet
 */
public class BouoCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BouoCustServlet() {
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
		String username = request.getParameter("username");
		CustomerDao dao =new CustomerDao();
		CustomerBean bean = dao.ByCustomerId(username);
		int customerId = bean.getCustormerId();
		CustomerAddrDao dao1 = new CustomerAddrDao();
		String detail = dao1.selectDetailByAddressId(customerId);
		OrderinfoDao dao2 = new OrderinfoDao();
		List<OrderinfoBean>list=dao2.selectOrderinfoBycustormerId(customerId);
		request.getSession().setAttribute("customerId", customerId);
		request.getSession().setAttribute("detail", detail);
		request.getSession().setAttribute("lista", list);
		response.sendRedirect("facadecust.jsp");
	}

}
