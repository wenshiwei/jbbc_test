package com.wf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.OtochannelBean;
import com.wf.dao.OtochannelDao;

/**
 * Servlet implementation class OtoChannelServlet
 */
public class OtoChannelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtoChannelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = (String) request.getSession().getAttribute("message");
		Object c=request.getSession().getAttribute("clothesCount");
		int count = (Integer) c;
		int orderId = (Integer) request.getSession().getAttribute("orderId");
		int custormerId = (Integer) request.getSession().getAttribute("custormerId");
		OtochannelDao dao = new OtochannelDao();
		OtochannelBean bean = new OtochannelBean();
		bean.setCustormerId(custormerId);
		bean.setCount(count);
		bean.setMessage(message);
		bean.setOrderId(orderId);
		dao.insertOtochannel(bean);
		System.out.println("½øÀ´ÁË¡£¡£¡£");
		response.sendRedirect("person_jsp.jsp");
	}

}
