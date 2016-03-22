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
 * Servlet implementation class CompleteCustPageServlet
 */
public class CompleteCustPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteCustPageServlet() {
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
		response.setHeader("Cache-Control", "no-cache");
		String currentPage1 = request.getParameter("currentPage");
		String flag = request.getParameter("flag");
		String username1 = request.getParameter("username1");
		String allPage1 = request.getParameter("allPage");
		
		int allPage = Integer.valueOf(allPage1);
		System.out.println("allPage="+allPage);
		int currentPage = 0;
		if(currentPage1==null){
			currentPage = 1;
		}else{
			currentPage = Integer.valueOf(currentPage1);
		}
		if(flag!=null){
			if(flag.equals("pre")){
				currentPage--;
			}
			if(flag.equals("next")){
				currentPage++;
			}
		}
		CustomerDao dao = new CustomerDao();
		CustomerBean bean = dao.ByCustomerId(username1);
		int customerId = bean.getCustormerId();
		Dao dao1 = new Dao();
		
		ArrayList<Bean> listd = (ArrayList<Bean>)dao1.selectDao(customerId, 6, currentPage);
			
		
		System.out.println("allPage="+allPage);
		if(allPage>1){
			
			request.getSession().setAttribute("allPage", allPage);
//			listd = (ArrayList<Bean>)dao1.selectDao(customerId, 6, currentPage);
		}
		request.getSession().setAttribute("allPage", allPage);
		request.getSession().setAttribute("listd", listd);
		request.getSession().setAttribute("username1", username1);
		request.getSession().setAttribute("currentPage", currentPage);
		response.sendRedirect("completecust.jsp");
	}

}
