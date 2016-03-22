package com.wf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.NoticeBean;
import com.wf.bean.PriceBean;
import com.wf.dao.NoticeDao;
import com.wf.dao.PriceDao;

/**
 * Servlet implementation class PriceAndNoticeServlet
 */
public class PriceAndNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceAndNoticeServlet() {
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
		String flag = request.getParameter("flag");
		String currentPage1 = request.getParameter("currentPage");
		int currentPage = 0;
		if(currentPage1==null){
			currentPage = 1;
		}else{
			currentPage = Integer.valueOf(currentPage1);
		}
		if(flag!=null){
			if(flag.equals("pre")){
				currentPage--;
			}
			if(flag.equals("next")){
				currentPage++;
			}
		}
		PrintWriter writer = response.getWriter();
		NoticeDao noticeDao = new NoticeDao();
		List<NoticeBean> list = noticeDao.selectNotice();
		request.getSession().setAttribute("list1", list);
		PriceDao dao = new PriceDao();
		int pageCount=dao.queryPageCount();
		request.getSession().setAttribute("currentPage", currentPage);
		List<PriceBean> list1 = dao.queryByPageIndex(currentPage);
		request.getSession().setAttribute("list", list1);
		request.getSession().setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("currentPage", currentPage);
//		response.sendRedirect("promotion_jsp.jsp");
		response.sendRedirect("index_jsp.jsp");
	}

}
