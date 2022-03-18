package com.greedy.section01.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first/message")
public class FirstMessageProjectServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 전달 된 파라미터를 꺼낼 때는 request의 getParameter 메소드를 이용한다. 
		 * 마찬가지로 응답 데이터에 한글이 포함되어 있는 경우, 응답에 대해 인코딩 설정을 해주어야 한다. 
		 * 이때 반환하는 데이터의 기본 형태는 text/plain이다. 
		 * */
		
		String message = request.getParameter("message");
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("I'm get!!" + message + "안녕하시오. 삼색이사랑해!");
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* POST 방식으로 요청 시에 인코딩 설정을 별도로 해주지 않아도 한글 데이터는 꺠지지 않는다
		 * $.ajax()로 요청하면 contentType이 application/x-www-form-urlencoded로 설정되며
		 * 기본인코딩 방식은 UTF-8로 인코딩 된 데이터가 전송 된다. */
		
		String message = request.getParameter("message");
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("I'm post!!" + message + "안녕하시오. 삼색이사랑해!");
		
		out.flush();
		out.close();
		
	}

}
