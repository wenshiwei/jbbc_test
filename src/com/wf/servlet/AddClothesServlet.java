package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.ClothesBean;
import com.wf.dao.ClothesDao;

/**
 * 登记某一订单下的衣服信息
 * @author 张凌铭
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
		//获取登记衣服的信息
		String ClothType=request.getParameter("ClothType");
		String ClothGrade=request.getParameter("ClothGrade");
		int NumberofCloth=Integer.valueOf(request.getParameter("NumberofCloth"));
		String MessagofCloth=request.getParameter("MessagofCloth");
		int OrderID=(Integer)request.getSession().getAttribute("OrderID");
		
		//封装登记的衣服对象，插入数据库
		ClothesBean cloth=new ClothesBean(OrderID,ClothType,ClothGrade,MessagofCloth,NumberofCloth);
		ClothesDao clothDao=new ClothesDao();
		//返回插入结果
		int clothesId=clothDao.insertClothes(cloth);
		//返回衣服登记界面继续登记衣服
		response.sendRedirect("clothes.jsp");
	}

}
