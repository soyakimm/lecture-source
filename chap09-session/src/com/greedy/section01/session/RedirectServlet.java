package com.greedy.section01.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 쿼리스트링을 통한 데이터 전달 */
		String test = request.getParameter("test");
		System.out.println("test : " + test);
		
		

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		/* 앞서 작성한 페이지와 동일한 세션 아이디를 반환한다. */
		HttpSession session = request.getSession();
		System.out.println("redirect 페이지 session id : " + session.getId());
		
		/* 세션에 담긴 모든 Attribute 키 목록을 반환 받을 수도 있다.
		 */
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		/* 동일한 아이디를 가진 세션에서는 setAttribute한 값을 getAttribute로 꺼내올 수 있다. */
		firstName = (String)session.getAttribute("firstName"); //null값에 동일한 데이터를 넣어주도록한다.
		lastName = (String)session.getAttribute("lastName");
		
		/* 꺼내온 값을 이용해서 페이지에 응답용 html 전송 */
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctpye html>\n")
					.append("<html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<h3>your first name is ")
					.append(firstName)
					.append(" and last name is ")
					.append(lastName)
					.append("<h3>")
					.append("</body>\n")
					.append("</html>\n");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(responseText.toString());
		out.flush();
		out.close();
		
		
	}

}
