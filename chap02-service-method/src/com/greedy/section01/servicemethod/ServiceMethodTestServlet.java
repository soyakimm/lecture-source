package com.greedy.section01.servicemethod;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		/* 나중에 HTTP를 대체할 프로토콜이 존재한다면 HttpServletRequest는 다른 클래스로 대체되어야 한다.
		 * 따라서 ServletRequest라는 추상화 된 타입으로 사용하고, 실제 인스턴스는 HttpServletRequest로 사용하게 되며
		 * 나중에 service 메소드의 인자 타입은 변경하지 않고 다른 프로토콜을 사용하는 Request로 변경이 가능할 것이다(=다형성)
		 */
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		/* 하위 타입으로 다운캐스팅 한 뒤 요청 받은 http 메소드가 어떤 메소드인지를 판단한다. */
		String httpMethod = httpRequest.getMethod(); //문자열로 된 요청메소드 타입 리턴
		
		System.out.println("http method : " + httpMethod);
		
		if("GET".equals(httpMethod)) {
			/* GET 요청을 처리할 메소드로 요청과 응답 정보를 전달한다. */
			doGet(httpRequest, httpResponse);
		} else if ("POST".equals(httpMethod)) {
			/* POST 요청을 처리할 메소드로 요청과 응답 정보를 전달한다. */
			doPost(httpRequest, httpResponse);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청을 처리할 메소드 호출됨...");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청을 처리할 메소드 호출됨...");
	}

}
