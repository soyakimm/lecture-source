package com.greedy.section03.jsonarray;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/receive/jsonarray")
public class ReceiveJsonArrayServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 응답 헤더의 content-type 설정을 application/json으로 한다. */
		response.setContentType("application/json; charset=UTF-8"); /*정해진 형식이기에, 오타에 주의하자*/
		
		PrintWriter out = response.getWriter();
		out.print("[{\"type\":\"get\",\"firstName\":\"soyeong\",\"lastName\":\"kim\",\"age\":20},"
				+ "{\"type\":\"get\",\"firstName\":\"haha\",\"lastName\":\"ha\",\"age\":20}]"); //하나의 객체
		//자바스크립트에서 하나의 객체를 다시 array안에 담을 수 있다. 
		
		out.flush();
		out.close();
	}

}
