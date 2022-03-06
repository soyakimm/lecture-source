package com.greedy.section01.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		/* redirect는 url을 재작성하여 url을 이용해 요청하는 방식이기 때문에 get 방식의 요청이다. 
		 * 따라서 redirect 되는 서블릿은 doGet 메소드 쪽에서 처리해야한다. */
		
		/* 서버측에서 쿠키값 저장하는 방법
		 * 쿠키를 사용하는 방법은 간단하며, 쿠키를 사용하는 절차가 존재한다.
		 * 1. 쿠키 생성한다
		 * 2. 해당 쿠키 만료 기간을 설정한다
		 * 3. 응답 헤더에 쿠키를 담는다
		 * 4. 응답(response)한다
		 * 
		 * 하지만 쿠키는 일부 제약 항목이 있다. 
		 * 쿠키의 이름은 아스키코드 문자만을 사용해야하며 한 번 설정한 쿠키의 이름은 변경할 수 없다.
		 * 또한 공백문자와 일부 특수문자([ ] ( ) = , " \ ? @ : ;)를 사용할 수 없다.
		 */
		Cookie firstNameCookie = new Cookie("firstName", firstName);
		Cookie lastNameCookie = new Cookie("lastName", lastName);
		
		// 초 단위 설정으로 하루를 만료시간으로 둘 때의 시간
		firstNameCookie.setMaxAge(60 * 60 * 24); // 만료시간 : 하루
		lastNameCookie.setMaxAge(60 * 60 * 24);
		
		response.addCookie(firstNameCookie);  //응답메소드 + addCookie 
		response.addCookie(lastNameCookie);
		//response쪽에다가 쿠키를 담아서 보낼 것이다.
		
		
		response.sendRedirect("redirect");
	}

}
