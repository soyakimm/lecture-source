package com.greedy.section02.list;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.model.dto.MemberDTO;

@WebServlet("/receive/list")
public class ReceiveListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO memeber1 = new MemberDTO("get", "soyeong", "kim", 20);
		MemberDTO memeber2 = new MemberDTO("get", "spider", "man", 22);
		
		List<MemberDTO> memberList = new ArrayList<>();
		memberList.add(memeber1);
		memberList.add(memeber2);
	
		System.out.println(memberList);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(memberList);
		
		out.flush();
		out.close();
	}
	

}
