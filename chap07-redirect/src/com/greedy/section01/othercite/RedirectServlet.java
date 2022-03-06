package com.greedy.section01.othercite;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("이 서블릿으로 redirect 성공!");
		
		StringBuilder redirectText = new StringBuilder();
		redirectText.append("<!doctype html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<b1>이 서블릿으로 redirect성공! </h1>")
					.append("</body>\n")
					.append("</html>");
					
					
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter(); /*clinet와 연결된 스트링 가져오기 (1) */
		
		out.print(redirectText.toString());
		/*위에서 작성한 redirect 텍스트를 문자열로 출력 */
		
		out.flush();
		out.close();
		
		/* redirect를 하는 경우 url이 재작성 되어 새로 고침 해도 redirect 된 페이지에 대한 요청만을 반복한다. 
		 * 즉, 이전 요청에 남아있던 정보는 더 이상 남아있지 않게 된다. 또한 url도 변경 된다.
		 * http 요청은 요청 시에 잠시 connection을 맺고 응답시에도 잠시 connection을 맺으며 
		 * 요청 단위 당 request 객체는 한 개만 생성이 된다. 
		 * 따라서 첫 요청 시 request와 redirect된 페이지의 request는 서로 다른 객체이다.
		 * 그렇기 때문에 redirect를 이용하게 되면 이전 서블릿의 값을 공유해서 사용할 수 없게 된다.
		 * 그럼 redirect시 값을 유지하는 방법은? 크게 쿠키와 세션이라는 것을 이용할 수 있다.
		 */
		
		
		
	}

	
}
