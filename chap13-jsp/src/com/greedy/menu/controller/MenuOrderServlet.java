package com.greedy.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 서블릿에서 하는 일
		 * 1. 요청 받은 값 확인 및 검증
		 * 2. 비지니스 로직 처리
		 * 3. 응답 페이지 생성 후 응답
		 * */
		
		/* 1. 요청에 대한 처리 */
		request.setCharacterEncoding("UTF-8");
		
		String menuName = request.getParameter("menuName");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		System.out.println("menuName : " + menuName);
		System.out.println("amount : " + amount);
		
		/* 2. 비즈니스 로직 처리 */
		/* 비즈니스 로직은 대부분 DB에 CRUD 연산 등을 이용해 이루어지게 된다.
		 * 여기서는 DB 연결을 할 것은 아니기 때문에 간단한 로직 처리만 해보자.
		 * */
		int orderPrice = 0;
		
		switch(menuName) {
		case "햄버거" : orderPrice = 6000 * amount; break;
		case "짜장면" : orderPrice = 7000 * amount; break;
		case "짬뽕" : orderPrice = 8000 * amount; break;
		case "순대국" : orderPrice = 9000 * amount; break;
		}
		
		/* 3. 응답 페이지를 생성 후 응답한다.
		 * 직접 페이지를 문자열로 생성한 뒤 스트림으로 내보내기를 할 수도 있지만
		 * 페이지 작성이 더 쉽고 응답을 보여주는 역할에 대해 구분하여 응답만 전용으로 할 수 있는 jsp쪽으로
		 * request에 값을 담은 뒤 forward 해서 화면에 출력해보자.
		 * */
		request.setAttribute("menuName", menuName);
		request.setAttribute("amount", amount);
		request.setAttribute("orderPrice", orderPrice);
		
		/* 서블릿 컨테이너 내부에서는 /root가 적용된 상태이다. */
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/5_response.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
		
	}

}















