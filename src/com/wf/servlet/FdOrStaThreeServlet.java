package com.wf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.dao.OrderinfoDao;

/**
 * 门面用户的第三种状态处理
 */
public class FdOrStaThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FdOrStaThreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] allCheckOrderId=request.getParameterValues("OrderCB");
		//处理多选
		for (String checkOrderId : allCheckOrderId) {
			int OrderID=Integer.valueOf(checkOrderId);
			/**********************操作数据库****************/
			OrderinfoDao facadeDao = new OrderinfoDao();
			//返回修改订单ID操作的状态
			boolean upstate=facadeDao.update0rderFacadeinfo(6, OrderID);
		}
		/************数据库修改成功后跳转到默认第一种状态*******************/
		response.sendRedirect("FdeOrderSendServlet?Status=5");	}

}
