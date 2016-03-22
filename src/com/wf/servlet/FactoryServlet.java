package com.wf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.Simplepojo;
import com.wf.dao.OrderinfoDao;
public class FactoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FactoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����������ݻ�ȡ��������facadeChanel������һ��������С�
		
		//��ȡ����״̬
		int status=Integer.valueOf(request.getParameter("Status"));
		
		//��ȡ��ǰҳ 
				int nowPages = (Integer) request.getSession().getAttribute("nowPages");
				
		OrderinfoDao factoryDao=new OrderinfoDao();
		//���ݹ�������Ա�Ͳ���״̬��ѯ
		ArrayList<Simplepojo> facOrderList=(ArrayList<Simplepojo>) factoryDao.selectSimplepojo(status);
		
		//�����ܵ�����ҳ��
				int allPages=facOrderList.size()/5;
				if(facOrderList.size()%5!=0){
					allPages +=1;
				}
				//����Ĭ��ҳ��Ϊ1
				request.getSession().setAttribute("allPages", 1);
				if(allPages>1){
					request.getSession().setAttribute("allPages", allPages);
					//������ҳ��
					facOrderList = (ArrayList<Simplepojo>) factoryDao.selectPages(status, (nowPages-1)*5);
				}
		
		request.getSession().setAttribute("facOrderList", facOrderList);
		
		response.sendRedirect("factory1.jsp");
		
	}

}
