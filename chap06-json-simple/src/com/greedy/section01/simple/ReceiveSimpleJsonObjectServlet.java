package com.greedy.section01.simple;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.greedy.model.dto.MemberDTO;

@WebServlet("/receive/simple")
public class ReceiveSimpleJsonObjectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = new MemberDTO("M01", "soyeong", "kim", 20);
		
		JSONObject json = new JSONObject();
		/* 원하는 key, value를 입력*/
		json.put("code", member.getCode());
		json.put("firstName", member.getFirstName());
		json.put("lastName", member.getLastName());
		json.put("age", member.getAge());
		
		/*json형태의 문자열로 출력 : json.toJSONString */
		System.out.println(json.toJSONString());
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(json.toJSONString());
		
		out.flush();
		out.close();
	}

}
