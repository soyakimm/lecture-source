package com.greedy.section01.javascript;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/javascript")
public class JavascriptAjaxTestServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		//응답하고자 하는 데이터
		String output = name + "님 확인합니다."; 
		
		//전체 html문서 데이터가 아닌 필요한 데이터만 호출하게 할 것이다.
		response.setContentType("text/plain; charset=UTF-8");
		
		//클라이언트에게 값 내보내기 | 출력스트림을 응답객체로부터 가져온다.
		PrintWriter out = response.getWriter();
		
		//응답하고자 하는 텍스트 출력
		out.print(output);
		
		out.flush();
		out.close();
		
	}



}
