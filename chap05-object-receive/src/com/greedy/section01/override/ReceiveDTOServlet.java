package com.greedy.section01.override;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.model.dto.MemberDTO;

@WebServlet("/receive/override")
public class ReceiveDTOServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO memeber = new MemberDTO("get", "soyeong", "kim", 20);
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		/* toString으로 리턴 받는 문자열을 json 포맷으로 맞춰두면 바로 java의 object도 json 문자열 형태로 출력할 수 있다. */
		out.print(memeber);
		
		out.flush();
		out.close();
		
	}


}
