package com.greedy.section01.jquery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jquery")
public class JQueryAjaxTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name"); //요청에서 넘겨온 파라미터 get
		
		String output = name + "님 환영합니다."; //응답값으로 보내기
		
		response.setContentType("text/plain; charset=UTF-8"); // '문자만 출력:plain'
		
		PrintWriter out = response.getWriter(); 
		out.print(output);
		
		out.flush();
		out.close();
		
		
	}


}
