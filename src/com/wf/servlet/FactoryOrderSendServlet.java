package com.wf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.OrderinfoStatus;
import com.wf.dao.OrderinfoDao;

/**
 * Servlet implementation class FactoryOrderSendServlet
 */
public class FactoryOrderSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FactoryOrderSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//获取订单状态
		int status=Integer.valueOf(request.getParameter("Status"));
		//获取当前页 
		int nowPages = (Integer) request.getSession().getAttribute("nowPages");
		
		OrderinfoDao facadeDao = new OrderinfoDao();
		//根据门店操作员和操作状态查询
		//查询总的记录
		ArrayList<OrderinfoStatus> facadesimpojo = (ArrayList<OrderinfoStatus>) facadeDao.selectOF(status);
		
		//计算总的数据页数
		int allPages=facadesimpojo.size()/5;
		if(facadesimpojo.size()%5!=0){
			allPages +=1;
		}
		
		//设置默认页数为1
		request.getSession().setAttribute("allPages", 1);
		if(allPages>1){
			//保存总页数
			request.getSession().setAttribute("allPages", allPages);
			//分页查询
			facadesimpojo = (ArrayList<OrderinfoStatus>) facadeDao.selectOFPages(status, (nowPages-1)*5);
		}
		
		request.getSession().setAttribute("facadesimpojo", facadesimpojo);
		// 跳转门面用户订单显示的界面
		response.sendRedirect("factory3.jsp");
		
	}

	}

