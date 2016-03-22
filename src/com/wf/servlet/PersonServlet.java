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
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
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
		
		System.out.println("username="+username);
		CustomerDao dao = new CustomerDao();
		CustomerBean bean = dao.ByCustomerId(username);
		int customerId = bean.getCustormerId();
		System.out.println("customerId="+customerId);
		CustomerAddrDao dao1 = new CustomerAddrDao();
		String detail = dao1.selectDetailByAddressId(customerId);
		System.out.println("detail="+detail);
		if(username==null){
			response.sendRedirect("index_jsp.jsp");
		}else{
			if(username.startsWith("*")){
				System.out.println("username="+username);
				request.getSession().setAttribute("detail", detail);
				request.getSession().setAttribute("loginId", username);
				response.sendRedirect("company_jsp.jsp");
			}else{
				request.getSession().setAttribute("detail", detail);
				request.getSession().setAttribute("loginId", username);
				response.sendRedirect("person_jsp.jsp");
			}
			
			
		}
	}

}
