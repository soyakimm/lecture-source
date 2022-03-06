package com.greedy.section03.requestlistener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {
	/* 처음에 attributeReplaced()가 호출이 되는 이유는
	 * org.apache.catalina.ASYNC_SUPPORTED라는 attribute가 자동 수정 되기 때문에 한 번 호출을 한다.
	 * => 신경쓰지 않아도 됨!
	 */
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*수행 기능 작성*/
		
		/*request에 attribute를 추가할 때 attributeAdded() 메소드가 동작한다. */
		request.setAttribute("username", "soyeongkim");
		request.setAttribute("age", 27);
		request.setAttribute("gender", "F");
		
		/*request에 attribute를 동일한 key로 덮어쓰는 경우 (==value 수정) attributeReplaced() 메소드가 동작한다. */
		request.setAttribute("username", "soyaa");
		
		/*request에 attribute를 제거 할 때 attributeRemoved() 메소드가 동작한다. */
		request.removeAttribute("gender");
	}


}
