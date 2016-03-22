package com.wf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.CustomerAddrBean;
import com.wf.bean.CustomerBean;
import com.wf.bean.NoticeBean;
import com.wf.dao.CustomerAddrDao;
import com.wf.dao.CustomerDao;
import com.wf.dao.NoticeDao;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
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
		String surepassword = request.getParameter("surepassword");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("telephone");
		String userType = request.getParameter("usertype");
		request.getSession().setAttribute("address", address);
		System.out.println("loginId="+loginId);
		if(loginId!=null){
			if(password!=null){
				if(surepassword!=null){
					if(password.equals(surepassword)){
						CustomerBean customer = new CustomerBean();
						customer.setTelName(null);
						customer.setLoginId(loginId);
						customer.setPassword(password);
						customer.setTelNumber(phoneNumber);
						customer.setCustormerId(0);
						customer.setCreateTime(null);
						CustomerDao dao = new CustomerDao();
						int cutomerId = dao.insertCustomer(customer);
						request.getSession().setAttribute("cutomerId", cutomerId);
						customer.setCustormerId(cutomerId);
						//�����ַ����Ϣbean��dao
						CustomerAddrBean customerAddr = new CustomerAddrBean();
						customerAddr.setAddressId(0);
						customerAddr.setCustormerId(cutomerId);
						customerAddr.setIsDefault("y");
						customerAddr.setDetail(address);
						CustomerAddrDao addrDao = new CustomerAddrDao();
						CustomerAddrBean addrBean = addrDao.insertCustomerAddrByCustomerId(customerAddr);
						request.getSession().setAttribute("currentPage", 1);
						response.sendRedirect("index_jsp.jsp");
					}
				}
				if(surepassword==null){
					System.out.println("�ظ�����Ϊ��");
				}
			}
			if(password==null){
				System.out.println("����Ϊ��");
			}
		}
		if(loginId==null){
			System.out.println("�û���Ϊ��");
		}
	}

}
