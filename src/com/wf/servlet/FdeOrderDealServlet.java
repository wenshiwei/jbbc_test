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
 * 门店用户订单处理状态的跳转
 * @author 张凌铭
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
		//获取操作员ID根据操作员ID查询订单
				int operatorId = (Integer) request.getSession().getAttribute("operatorId");
				//获取订单状态
				int status=Integer.valueOf(request.getParameter("Status"));
				//获取当前页 
				int nowPages = (Integer) request.getSession().getAttribute("nowPages");
				
				OrderinfoDao facadeDao = new OrderinfoDao();
				//根据门店操作员和操作状态查询
				ArrayList<Simplepojo> facadesimpojo = (ArrayList<Simplepojo>) facadeDao.selectSimplepojo(operatorId,status);
				
				//计算总的数据页数
				int allPages=facadesimpojo.size()/5;
				if(facadesimpojo.size()%5!=0){
					allPages +=1;
				}
				
				//设置默认页数为1
				request.getSession().setAttribute("allPages", 1);
				if(allPages>1){
					request.getSession().setAttribute("allPages", allPages);
					//保存总页数
					facadesimpojo = (ArrayList<Simplepojo>) facadeDao.selectPages(operatorId, status, (nowPages-1)*5);
				}
				
				request.getSession().setAttribute("facadesimpojo", facadesimpojo);
				// 跳转门面用户订单显示的界面
				response.sendRedirect("facade2.jsp");
	}

}
