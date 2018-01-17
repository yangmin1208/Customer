package com.ym.customer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ym.customer.dao.CustomerDao;
import com.ym.customer.domain.Customer;


public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setBirthday(request.getParameter("date"));
		customer.setGender(request.getParameter("gender"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));
		customer.setDesc(request.getParameter("description"));
		
		//System.out.println(customer.toString());
		CustomerDao cd = new CustomerDao();
		cd.addCustomer(customer);
		request.setAttribute("name", customer.getName());
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
