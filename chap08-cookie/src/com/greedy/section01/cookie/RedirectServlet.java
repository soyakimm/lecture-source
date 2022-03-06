package com.greedy.section01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		/* null 값이 나오는 것을 확인할 수 있다.
		 * 따라서 request는 공유되지 않는다는 것을 볼 수 있다.
		 */
		
		/* 쿠키를 사용하는 방법
		 * 1. request에서 쿠키 목록을 '쿠키 배열 형태'로 꺼내온다.
		 * 2. 쿠키의 getName과 getValue를 이용해 쿠키에 담긴 값을 사용한다.
		 * */
		
		Cookie[] cookies = request.getCookies(); //cookie의 배열 형태로 쿠키목록을 가져오기 때문에, cookie[] 배열형태로 받아주어야한다.
		
		for(int i = 0; i < cookies.length; i++) {
			System.out.println("[cookie]" + cookies[i].getName() + " : " + cookies[i].getValue());
			
			//null로 나오는 값 설정
			if("firstName".equals(cookies[i].getName())) {
				firstName = cookies[i].getValue();
			} else if ("lastName".equals(cookies[i].getName())) {
				lastName = cookies[i].getValue();
			}
			
		}
		
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
		//응답화면을봤을때 처음에 입력했던 firstName과 lastName을 클라이언트쪽에 쿠키 집어넣은 동작 
		//-> 클라이언트가 저장하고 요청쪽에 포함쪽에 보내주기 때문에 
		// 그걸 뽑아서 이용한 동적인 페이지를 볼 수 있게 된다.
		
		/* 쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장 된다.
		 * 다른 사용자와 함께 사용하는 컴퓨터인 경우 쿠키에 민감한 개인 정보를 담기에는 보안에 취약해지는 문제가 있다.
		 * 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다는 세션을 이용하게 된다.
		 * 세션은 쿠키와 유사한 형태로 key=value 쌍으로 저장 되지만 서버(톰캣)에서 관리 되기 때문에 보안에 더 우수하다.
		 */
		
	}

}
