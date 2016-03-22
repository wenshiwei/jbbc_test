package com.wf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.CustomerBean;
import com.wf.dao.CustomerAddrDao;
import com.wf.dao.CustomerDao;

/**
 * Servlet implementation class AddressUpdateServlet
 */
public class AddressUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressUpdateServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String updateAddress = request.getParameter("updateAddress");
		System.out.println("updateAddress="+updateAddress);
		System.out.println("username="+username);
		CustomerDao dao = new CustomerDao();
		CustomerBean bean = dao.ByCustomerId(username);
		int customerId = bean.getCustormerId();
		CustomerAddrDao dao1 = new CustomerAddrDao();
		dao1.updateDetailByCustomerId(customerId, updateAddress);
		response.sendRedirect("person_jsp.jsp");
	}

}
