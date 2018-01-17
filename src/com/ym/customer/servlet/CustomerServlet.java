package com.ym.customer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ym.customer.dao.CustomerDao;
import com.ym.customer.domain.Customer;
import com.ym.customer.domain.PageBean;

public class CustomerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//进行分页操作
		int pc = getPage(request);//得到当前页码
		int pageSize = 10;
		PageBean<Customer> pbBean = CustomerDao.findAll(pc,pageSize);
		request.setAttribute("pb", pbBean);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	private int getPage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String pageCode = request.getParameter("page");
		if (pageCode==null||pageCode.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(pageCode);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
