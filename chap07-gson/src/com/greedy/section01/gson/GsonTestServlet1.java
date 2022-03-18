package com.greedy.section01.gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.greedy.model.dto.MemberDTO;

@WebServlet("/gson/test1")
public class GsonTestServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = new MemberDTO("MO1", "소영", "김", 20);
		
		/*비동기적인 통신의 응답 데이터로 만들어보자*/
		Gson gson = new Gson(); 
		
		/*toJson으로 json 문자열을 만들 수 있다.*/
		String jsonString  = gson.toJson(member);
		System.out.println(jsonString);
		
		/*json 문자열을 다시 Object로 변환할 수 있다.*/
		MemberDTO jsonMember = gson.fromJson(jsonString, MemberDTO.class);
		System.out.println(jsonMember);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		
		out.flush();
		out.close();
		
	}


}
