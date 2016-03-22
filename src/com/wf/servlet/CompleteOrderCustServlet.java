package com.wf.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.Bean;
import com.wf.bean.CustomerBean;
import com.wf.dao.CustomerDao;
import com.wf.dao.Dao;

/**
 * Servlet implementation class CompleteOrderCustServlet
 */
public class CompleteOrderCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteOrderCustServlet() {
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
		String username1 = request.getParameter("username1");
		//
		CustomerDao dao = new CustomerDao();
		CustomerBean bean = dao.ByCustomerId(username1);
		int customerId = bean.getCustormerId();
		Dao dao1 = new Dao();
		
		ArrayList<Bean> listd = (ArrayList<Bean>)dao1.selectDao(customerId, 6, 1);
		
		int allPage = listd.size()/7;
		
		if(listd.size()/7!=0){
			
			allPage = allPage+1;
		}
		if(allPage>1){
			
			request.getSession().setAttribute("allPage", allPage);
//			listd = (ArrayList<Bean>)dao1.selectDao(customerId, 6, currentPage);
		}
		request.getSession().setAttribute("allPage", allPage);
		request.getSession().setAttribute("listd", listd);
		request.getSession().setAttribute("username1", username1);
		response.sendRedirect("completecust.jsp");
	}

}
