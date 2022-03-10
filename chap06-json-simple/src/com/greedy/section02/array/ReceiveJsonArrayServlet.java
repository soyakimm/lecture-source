package com.greedy.section02.array;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.greedy.model.dto.MemberDTO;

@WebServlet("/receive/array")
public class ReceiveJsonArrayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member1 = new MemberDTO("M01", "소영", "김", 20);
		MemberDTO member2 = new MemberDTO("M02", "무", "순", 13);
		
		List<MemberDTO> memberList = new ArrayList<>();
		memberList.add(member1);
		memberList.add(member2);
		
		JSONArray jsonArray = new JSONArray();
		for(MemberDTO member : memberList) {
			JSONObject json = new JSONObject();
			/* 원하는 key, value를 입력*/
			json.put("code", member.getCode());
			json.put("firstName", member.getFirstName());
			json.put("lastName", member.getLastName());
			json.put("age", member.getAge());
			
			jsonArray.add(json);
		}
		
		System.out.println(jsonArray.toJSONString()); //json배열을 string형태로 만들어주세요.
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(jsonArray.toJSONString());
		
		out.flush();
		out.close();
		
	}


}
