package com.greedy.section02.sessionlistener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* session을 최초 발급 받을 시 sessionCreated() 메소드가 동작한다 */
		//request.getSession(); : 세션이 만들어짐
		HttpSession session = request.getSession(); 
		System.out.println("발급 받을 session id : " + session.getId());
		
		
		/*session에 attribute를 추가할 때 attributeAdded() 메소드가 동작한다. */
		session.setAttribute("username", "soyeongkim");
		session.setAttribute("age", 20);
		session.setAttribute("gender", "F");
		
		/*session에 attribute를 동일한 key로 덮어쓰는 경우 (==value 수정) attributeReplaced() 메소드가 동작한다. */
		session.setAttribute("username", "soyaa");
		
		/*session에 attribute를 제거할 때 attributeRemoved()가 동작한다. */
		session.removeAttribute("gender");
		
		
		/* session을 만료하게 되면 sessionDestroyed() 메소드가 동작한다. */
		session.invalidate();
	}


}
