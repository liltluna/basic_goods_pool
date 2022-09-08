package com.example.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GLogin extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HashMap<String, String> result = new HashMap<>();
		result.put("username", username);
		result.put("password", password);
		request.setAttribute("infoList", result);
		RequestDispatcher view = request.getRequestDispatcher("login_result.jsp");
		view.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.sendRedirect("login.html");
	}
}