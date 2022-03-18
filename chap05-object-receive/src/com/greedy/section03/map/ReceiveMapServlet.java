package com.greedy.section03.map;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.model.dto.MemberDTO;

@WebServlet("/receive/map")
public class ReceiveMapServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO memeber1 = new MemberDTO("get", "soyeong", "kim", 20);
		MemberDTO memeber2 = new MemberDTO("get", "spider", "man", 22);
		
		Map<String, MemberDTO> memberMap = new HashMap<>();
		memberMap.put("one", memeber1);  /* Map은 key:value*/
		memberMap.put("two", memeber2);
		
		StringBuilder sb = new StringBuilder(); //문자수정을 위해 append() 진행
		Iterator<String> keyIter = memberMap.keySet().iterator();
		
		sb.append("{");
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			sb.append("\"").append(key).append("\":").append(memberMap.get(key)/*value값*/);
			
			if(keyIter.hasNext()) { //다음 칸이 돌아가요? == 다음 객체 있어요?
				sb.append(",");
				
			}
		}
		sb.append("}");
		
		System.out.println(sb);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(sb.toString());
		
		out.flush();
		out.close();
		
		
	}

}
