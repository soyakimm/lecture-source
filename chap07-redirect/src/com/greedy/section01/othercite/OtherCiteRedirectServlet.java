package com.greedy.section01.othercite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/othercite")
	public class OtherCiteRedirectServlet extends HttpServlet {
	       
		  
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println("get 요청 후 naver 사이트로 redirect");
		/* 브라우저의 개발자 도구 network 탭을 보면 302번 status code와 함께 naver 사이트로 이동하는 것을 볼 수 있다.
		 * 사용자 url 재작성이라고 불리는 redirect방식은 302번 응답 코드인 경우 요청에 대한 처리를 잘 했으며
		 * 사용자의 url을 강제적으로 redirect경로로 이동시키라는 의미이다. */
		response.sendRedirect("http://www.naver.com"); //sendRedirect 메소드 : 
		
	}

}
