package com.greedy.section01.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* forward 받은 서블릿에서도 요청 방식이 get이면 doGet 메소드를, 요청 방식이 post이면 doPost 메소드를 호출한다. */
		/* request에 이전 서블릿에서 전달하고자 하는 정보를 담았기 때문에 해당 서블릿에서는 다시 꺼내온다. */
		
		
		String userId = (String)request.getAttribute("userId");
		/* 저장한 타입이 최상위 타입 object로 추상화했기 때문에, 꺼내올때는 downcasting이 필요하다 */
		System.out.println("forward 확인 : " + userId);
		
		/* 응답에 필요한 데이터가 다 준비 되면 동적인 웹 페이지를 생성한다 */
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html>\n")
					.append("<html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<h3 align = 'center'>")
					.append(userId)
					.append("님 환영합니다.</h3>")
					.append("</body>\n")
					.append("</html>");
		/* id에 따라서 ~님 환영합니다 라는 것을 출력한다 */
		
		response.setContentType("text/html; charset=UTF-8"); //출력 전 문자와 출력형식을 맞춰주어야 한다.
		
		PrintWriter out = response.getWriter();
		
		out.print(responseText.toString()); //print로 해당 문자열로 출력하겠다.
		
		out.flush();
		
		out.close();
		
		/* 변수의 기본 스코프는 메소드(page)이기 때문에 다른 페이지(서블릿)으로 데이터 공유 불가
		 * forward 방식은 request와 response를 넣어서 위임하므로 
		 * request에 정보를 저장하여 forward했을 경우 위임 당한 서블릿에서도 서블릿의 정보를 공유할 수 있게 된다.
		 * 또한 forward 방식은 해당 서블릿의 존재를 client가 알 필요가 없어 url 자체가 변경 되지 않는다.
		 * 단, 서버로 전송한 데이터가 남아있는 상태로 새로고침(재요청)을 하게되면 요청을 게속 반복하게 되어
		 * DB에 insert하는 행위가 반복 되어 중복 행이 발생하는 등의 문제가 있을 수 있다.
		 * 이러한 경우는 또 다른 페이지 전환 방식 sendRedirect를 사용해야 한다. (플렉스 필기 참고)  
		 */
					
					
					
					
					
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
