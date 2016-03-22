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
		//工厂界面数据获取，操作表facadeChanel表，返回一个对象队列。
		
		//获取订单状态
		int status=Integer.valueOf(request.getParameter("Status"));
		
		//获取当前页 
				int nowPages = (Integer) request.getSession().getAttribute("nowPages");
				
		OrderinfoDao factoryDao=new OrderinfoDao();
		//根据工厂操作员和操作状态查询
		ArrayList<Simplepojo> facOrderList=(ArrayList<Simplepojo>) factoryDao.selectSimplepojo(status);
		
		//计算总的数据页数
				int allPages=facOrderList.size()/5;
				if(facOrderList.size()%5!=0){
					allPages +=1;
				}
				//设置默认页数为1
				request.getSession().setAttribute("allPages", 1);
				if(allPages>1){
					request.getSession().setAttribute("allPages", allPages);
					//保存总页数
					facOrderList = (ArrayList<Simplepojo>) factoryDao.selectPages(status, (nowPages-1)*5);
				}
		
		request.getSession().setAttribute("facOrderList", facOrderList);
		
		response.sendRedirect("factory1.jsp");
		
	}

}
