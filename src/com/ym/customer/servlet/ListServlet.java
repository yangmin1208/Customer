package com.ym.customer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ym.customer.dao.CustomerDao;
import com.ym.customer.domain.Customer;

public class ListServlet extends HttpServlet {


	List<Customer> list = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		list = new ArrayList<Customer>();
		list = CustomerDao.findAllCustomers();
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("../list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
