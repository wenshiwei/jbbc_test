package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.dao.OrderinfoDao;

/**
 * Servlet implementation class FactoryStaTwoServlet
 */
public class FactoryStaTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FactoryStaTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] allCheckOrderId=request.getParameterValues("OrderCB");
		for (String checkOrderId : allCheckOrderId) {
			int OrderID=Integer.valueOf(checkOrderId);
			/**********************�������ݿ�****************/
			OrderinfoDao facadeDao = new OrderinfoDao();
			//���ز����״̬
			boolean upstate=facadeDao.update0rderFacadeinfo(4, OrderID);
		}
		/************���ݿ��޸ĳɹ�����ת��Ĭ�ϵ�һ��״̬*******************/
		response.sendRedirect("FactoryDrderDealServlet?Status=3");
	
	}
}
