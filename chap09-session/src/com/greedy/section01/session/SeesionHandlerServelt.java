package com.greedy.section01.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SeesionHandlerServelt extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		
		/* 이전 챕터에서는 값을 유지하기 위한 기술로 쿠키를 이용해보았다.
		 * 하지만 쿠키의 보안적인 단점과 지원하지 않는 브라우저 문제 등으로 상태를 유지해야하는 매커니즘이 적합하지 않은 경우들이 다수 있다. 
		 * 특히, 회원 정보를 이용해서 회원의 로그인 상태를 지속적으로 유지해야하는 경우가 그러하다.
		 * 그렇기에 서버 쪽에서 조금 더 안전하게 관리 되는 '세션(session)이라는 인스턴스를 이용해서 상태를 유지하는 메커니즘을 제공하고 있다.
		 * HttpSession은 직접 생성할 수는 없고, request에 있는 getSession() 메소드를 이용해서 리턴 받는다.
		 */
		
		//newHttpSession이 아닌 request.getSession();으로 session을 생성할 수 있다.
		HttpSession session = request.getSession();
		
		/* 세션은 강제로 만료 시킬 수 있는 긴으도 있지만, 만료 시간을 설정해주는 것이 좋다.
		 * 설정 된 기본 시간은 30분이며, 필요에 따라 늘리거나 줄이면 된다. */
		System.out.println("session defualt 유지 시간 : " + session.getMaxInactiveInterval());
		
		session.setMaxInactiveInterval(60 * 10); // 세션 만료 시간을 10분으로 결정
		System.out.println("변경 후 session 유지 시간 : " + session.getMaxInactiveInterval());
		
		/* 세션은 브라우저 당 한 개 씩 고유한 아이디를 가지고 하나의 인스턴스를 이용한다.
		 * 매번 반복적인 요청 시 동일한 session id를 리턴한다.
		 */
		System.out.println("session id : " + session.getId());
		
		/* 세션은 redirect를 해도 값을 유지할 수 있는 request보다 더 넓은 범위의 공유 영역이라고 표현할 수 있다. 
		 * 세션에 값을 담을 때 setAttribute(String key, Object value) 형태로 담을 수 있고,
		 * 값을 꺼낼 때에는 key를 이용해서 getAttribute(key)를 이용해 꺼내게 된다. */
		session.setAttribute("firstName", firstName);
		session.setAttribute("lasttName", lastName);
		
		
		
		response.sendRedirect("redirect?test=hello"); //쿼리스트링으로 url창에 데이터를 넘길 수 있음을 확인할 수 있다.
		 
		
	}

}
