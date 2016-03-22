package com.wf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.NoticeBean;
import com.wf.dao.NoticeDao;

/**
 * Servlet implementation class NoticeServlet
 */
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
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
		response.setHeader("Cache-Control", "no-cache");
		String username = request.getParameter("loginId");
		PrintWriter writer = response.getWriter();
		writer.write("promotion_jsp");
		NoticeDao noticeDao = new NoticeDao();
		List<NoticeBean> list = noticeDao.selectNotice();
		request.getSession().setAttribute("list1", list);
		String title = request.getParameter("title");
		NoticeDao dao = new NoticeDao();
		String content = dao.selectContentByTitle(title);
		request.getSession().setAttribute("message", content);
		request.getSession().setAttribute("loginId", username);
		response.sendRedirect("promotion_jsp.jsp");
	}

}
