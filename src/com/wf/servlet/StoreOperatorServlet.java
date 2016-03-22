package com.wf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.bean.OperatorBean;
import com.wf.dao.OperatorDao;

/**
 * �ŵ��û���¼��֤��servlet
 * 
 * @author ������
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

		
		// ����Աdao�࣬������֤��¼
		OperatorDao operator = new OperatorDao();
		OperatorBean opreatorBean = operator.checkOprLogin(operatorLoginId, operatorType);
		
		if (opreatorBean != null && (opreatorBean.getPassword()).equals(operatorPwd)) {
			//��ȡ����ԱID
			int operatorId=opreatorBean.getOperatorId();
			
			request.getSession().setAttribute("operatorId", operatorId);
			
			
			// ��¼�ɹ������ݵ�¼������ת�������û�����͹����û�����
			if (operatorType == 2) {
				// �����û������servlet
				//����Ĭ�ϵĵ�ǰҳ��Ϊ��һҳ
				request.getSession().setAttribute("nowPages", 1);
				response.sendRedirect("FactoryServlet?Status=0");
			}
			
			else{
			
				// ��ת�������û�����servlet
				//����Ĭ�ϵĵ�ǰҳ��Ϊ��һҳ
				request.getSession().setAttribute("nowPages", 1);
				response.sendRedirect("FacadeServlet?Status=1");
			}
			
		} 
		
		else {
			// ������ʾ���¼ʧ�ܣ���ת����¼����
			response.sendRedirect("opreaterLogin.jsp");
		}

	}

}
