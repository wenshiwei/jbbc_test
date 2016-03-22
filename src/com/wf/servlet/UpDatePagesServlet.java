package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��������ҳ�л�ʱ����ǰҳ����ת��Servlet
 */
public class UpDatePagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpDatePagesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����ҳ����ʱ����ȡ��Ҫ��������ҳ�������Ҹ���״̬����ָ�������ݲ�ѯ��Servlet
		int NowPage = Integer.valueOf(request.getParameter("NowPage"));
		int status = Integer.valueOf(request.getParameter("Status"));
		//�� Ҫ��ת����ҳ�����õ�Session�з����ѯ����ʱ�Ļ�ȡ
		request.getSession().setAttribute("nowPages", NowPage);
		if (status == 1) {
			response.sendRedirect("FacadeServlet?Status=" + status);
		} else if (status == 2) {
			response.sendRedirect("FdeOrderDealServlet?Status=" + status);
		} else if (status == 3) {
			response.sendRedirect("FdeOrderSendServlet?Status=" + status);
		}
	}

}
