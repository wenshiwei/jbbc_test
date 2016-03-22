package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.ClothesBean;
import com.wf.dao.ClothesDao;

/**
 * �Ǽ�ĳһ�����µ��·���Ϣ
 * @author ������
 *
 */
public class AddClothesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddClothesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�Ǽ��·�����Ϣ
		String ClothType=request.getParameter("ClothType");
		String ClothGrade=request.getParameter("ClothGrade");
		int NumberofCloth=Integer.valueOf(request.getParameter("NumberofCloth"));
		String MessagofCloth=request.getParameter("MessagofCloth");
		int OrderID=(Integer)request.getSession().getAttribute("OrderID");
		
		//��װ�Ǽǵ��·����󣬲������ݿ�
		ClothesBean cloth=new ClothesBean(OrderID,ClothType,ClothGrade,MessagofCloth,NumberofCloth);
		ClothesDao clothDao=new ClothesDao();
		//���ز�����
		int clothesId=clothDao.insertClothes(cloth);
		//�����·��Ǽǽ�������Ǽ��·�
		response.sendRedirect("clothes.jsp");
	}

}
