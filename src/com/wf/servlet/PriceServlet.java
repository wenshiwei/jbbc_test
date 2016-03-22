package com.wf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.PriceBean;
import com.wf.dao.PriceDao;

/**
 * Servlet implementation class PriceServlet
 */
public class PriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceServlet() {
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
		String username = request.getParameter("username");
		//person_jsp页面前台的Ajax衣服的等级
		String clothesLevel = request.getParameter("clothesLevel");
		PriceDao dao = new PriceDao();
		int pageCount=dao.queryPageCount();
		int currentPage = 1;
		
				String flag = request.getParameter("flag");
				if(flag!=null){
					if(flag.equals("pre")){
						currentPage--;
					}
					if(flag.equals("next")){
						currentPage++;
					}
				}
				
				List<PriceBean> list = dao.queryByPageIndex(currentPage);
				request.getSession().setAttribute("list", list);
				request.getSession().setAttribute("pageCount", pageCount);
				request.getSession().setAttribute("currentPage", currentPage);
				request.getSession().setAttribute("companyId", username);
				response.sendRedirect("index_person.jsp");
			
		}

}
