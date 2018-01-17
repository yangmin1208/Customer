package com.ym.customer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ym.customer.dao.CustomerDao;
import com.ym.customer.domain.Customer;

public class QueryServlet extends HttpServlet {

	Customer customer = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		customer = new Customer();
		customer = CustomerDao.findCustomerById(request.getParameter("id"));
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("../listone.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
