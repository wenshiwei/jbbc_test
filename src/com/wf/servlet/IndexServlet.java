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
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		
		String loginId = request.getParameter("username");
		String password = request.getParameter("password");
		//��ҵ�û�
		String company = (String) request.getAttribute("company");
		String flag = request.getParameter("flag");
		if(flag==null){
			String message = (String) request.getAttribute("message");
			CustomerDao dao = new CustomerDao();
			CustomerBean  bean = dao.ByCustomerId(loginId);
			if(password!=null&&(bean.getPassword())!=null){
				if((bean.getPassword()).equals(password)){
					if(loginId.startsWith("*")){
						request.getSession().setAttribute("loginId", loginId);
						response.sendRedirect("company_jsp.jsp");
						CustomerDao dao1 = new CustomerDao();
						CustomerBean bean1 = dao1.ByCustomerId(loginId);
						int customerId = bean1.getCustormerId();
						CustomerAddrDao dao2 = new CustomerAddrDao();
						String detail = dao2.selectDetailByAddressId(customerId);
						request.getSession().setAttribute("detail", detail);
					}else{
						request.getSession().setAttribute("loginId", loginId);
						CustomerDao dao1 = new CustomerDao();
						CustomerBean bean1 = dao1.ByCustomerId(loginId);
						int customerId = bean1.getCustormerId();
						CustomerAddrDao dao2 = new CustomerAddrDao();
						String detail = dao2.selectDetailByAddressId(customerId);
						request.getSession().setAttribute("detail", detail);
						response.sendRedirect("PriceServlet");
					}
					
				}else{
					System.out.println("�������");
				}
			}else{
				response.sendRedirect("index_jsp.jsp");
			}
		}else{
			if(company.equals("y")){
				request.getSession().setAttribute("loginId", loginId);
				System.out.println("loginId1="+loginId);
				response.sendRedirect("company_jsp.jsp");
			}else{
				request.getSession().setAttribute("loginId", loginId);
				
				response.sendRedirect("index_person.jsp");
			}
				
		}
	}

}
