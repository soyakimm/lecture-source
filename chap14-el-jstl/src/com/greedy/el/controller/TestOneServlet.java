package com.greedy.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class TestOneServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("name", "스파이더맨");
		request.setAttribute("age", 20);
		request.setAttribute("phone", "010-1234-5678");
	
		List<String> items = new ArrayList<>();
		items.add(new String("apple"));
		items.add(new String("banana"));
		items.add(new String("melon"));
		
		request.setAttribute("items", items);
		
		RequestDispatcher view = request.getRequestDispatcher("views/el/testEl1.jsp");
		view.forward(request, response);
	
	}


}
