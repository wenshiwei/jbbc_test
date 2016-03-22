package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.dao.OrderinfoDao;

/**
 * �޸����ݿ��ж�����Ķ���״̬
 * 
 * @author ������
 *
 */

public class UpdaOrderStaeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdaOrderStaeServlet() {
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
		// ��ȡ�Ǽ��·���Ķ����ţ����ݶ��������޸ĸö�����״̬��
		int OrderID = (Integer) request.getSession().getAttribute("OrderID");
		int operatorId=(Integer) request.getSession().getAttribute("operatorId");
		
		/********************** �������ݿ� ****************/
		OrderinfoDao facadeDao = new OrderinfoDao();
		
		/*****************���ݲ���ԱID���޸Ķ�����еĶ���״̬****************/
		//�ŵ����Ա
		// ���ز����״̬
		boolean upstate = facadeDao.update0rderFacadeinfo(2, OrderID);

		/************ ���ݿ��޸ĳɹ�����ת��Ĭ�ϵ�һ��״̬ *******************/

		response.sendRedirect("FacadeServlet?Status=1");
	}

}
