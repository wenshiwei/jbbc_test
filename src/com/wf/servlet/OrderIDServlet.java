package com.wf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.FacadeBean;
import com.wf.dao.FacadeDao;
import com.wf.dao.OrderinfoDao;

/**
 * ���涩��ID��servlet
 * 
 * @author ������
 *
 */
public class OrderIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderIDServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int OrderID = Integer.valueOf(request.getParameter("OrderID"));
		
		request.getSession().setAttribute("OrderID", OrderID);
		int status=Integer.valueOf(request.getParameter("Status"));
		if(status==0){
			//���ݶ���ID��ѯ������ַ
			OrderinfoDao qurreyOrderAddrres=new OrderinfoDao();
			String orderAddress =qurreyOrderAddrres.selectOC(OrderID).getDetail();
			//����ַ���õ�Session��
			request.getSession().setAttribute("OrderAddress", orderAddress);
			/****************�������ݿ�***********************/
			FacadeDao facadeData=new FacadeDao();
			ArrayList<FacadeBean> listFacadeData= (ArrayList<FacadeBean>) facadeData.selectFacade();
			/************����һ���ò���Ա���ŵ����Ķ���***************/
			request.getSession().setAttribute("listFacadeData", listFacadeData);
			response.sendRedirect("zhipaimessage.jsp");	
		}
		if(status==1){
		response.sendRedirect("clothes.jsp");
		}
	}

}
