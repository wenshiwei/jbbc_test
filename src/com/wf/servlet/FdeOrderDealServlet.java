package com.wf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.Simplepojo;
import com.wf.dao.OrderinfoDao;

/**
 * �ŵ��û���������״̬����ת
 * @author ������
 *
 */
public class FdeOrderDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FdeOrderDealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
			doPost(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����ԱID���ݲ���ԱID��ѯ����
				int operatorId = (Integer) request.getSession().getAttribute("operatorId");
				//��ȡ����״̬
				int status=Integer.valueOf(request.getParameter("Status"));
				//��ȡ��ǰҳ 
				int nowPages = (Integer) request.getSession().getAttribute("nowPages");
				
				OrderinfoDao facadeDao = new OrderinfoDao();
				//�����ŵ����Ա�Ͳ���״̬��ѯ
				ArrayList<Simplepojo> facadesimpojo = (ArrayList<Simplepojo>) facadeDao.selectSimplepojo(operatorId,status);
				
				//�����ܵ�����ҳ��
				int allPages=facadesimpojo.size()/5;
				if(facadesimpojo.size()%5!=0){
					allPages +=1;
				}
				
				//����Ĭ��ҳ��Ϊ1
				request.getSession().setAttribute("allPages", 1);
				if(allPages>1){
					request.getSession().setAttribute("allPages", allPages);
					//������ҳ��
					facadesimpojo = (ArrayList<Simplepojo>) facadeDao.selectPages(operatorId, status, (nowPages-1)*5);
				}
				
				request.getSession().setAttribute("facadesimpojo", facadesimpojo);
				// ��ת�����û�������ʾ�Ľ���
				response.sendRedirect("facade2.jsp");
	}

}
