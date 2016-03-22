package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.dao.OrderinfoDao;

/**
 * Servlet implementation class ZhiDinOpreaterServlet
 */
public class ZhiDinOpreaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZhiDinOpreaterServlet() {
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
			int OrderID=(Integer)request.getSession().getAttribute("OrderID");
			int opreaterId=Integer.valueOf(request.getParameter("FacID"));
			
			//���ݶ���id��ָ���Ĳ���ԱIDȥ�޸�order���е�״̬Ϊ1�͸�������ԱID��
			
			/***********************�������ݿ�***************/
			OrderinfoDao orderInfo=new OrderinfoDao();
			int state=orderInfo.update0rderFactoryinfo(OrderID, opreaterId, 1);
			//��ת��FactoryServlet
			response.sendRedirect("FactoryServlet?Status=0");
	}

}
