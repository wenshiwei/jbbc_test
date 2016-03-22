package com.wf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.OperatorBean;
import com.wf.dao.OperatorDao;

/**
 * 门店用户登录验证的servlet
 * 
 * @author 张凌铭
 *
 */
public class StoreOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StoreOperatorServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		String operatorID = request.getParameter("userName");
		String operatorPwd = request.getParameter("userPwd");
		int operatorType = Integer.valueOf(request.getParameter("u1"));
		int operatorLoginId = Integer.valueOf(operatorID);

		
		// 操作员dao类，用于验证登录
		OperatorDao operator = new OperatorDao();
		OperatorBean opreatorBean = operator.checkOprLogin(operatorLoginId, operatorType);
		
		if (opreatorBean != null && (opreatorBean.getPassword()).equals(operatorPwd)) {
			//获取操作员ID
			int operatorId=opreatorBean.getOperatorId();
			
			request.getSession().setAttribute("operatorId", operatorId);
			
			
			// 登录成功，根据登录类型跳转至门面用户界面和工厂用户界面
			if (operatorType == 2) {
				// 工厂用户界面的servlet
				//设置默认的当前页数为第一页
				request.getSession().setAttribute("nowPages", 1);
				response.sendRedirect("FactoryServlet?Status=0");
			}
			
			else{
			
				// 跳转至门面用户界面servlet
				//设置默认的当前页数为第一页
				request.getSession().setAttribute("nowPages", 1);
				response.sendRedirect("FacadeServlet?Status=1");
			}
			
		} 
		
		else {
			// 弹出提示框登录失败，跳转至登录界面
			response.sendRedirect("opreaterLogin.jsp");
		}

	}

}
