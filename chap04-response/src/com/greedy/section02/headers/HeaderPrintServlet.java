package com.greedy.section02.headers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headers")
public class HeaderPrintServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* request header 출력 */
		Enumeration<String> headerNames = request.getHeaderNames();   //요청에 대한 header정보
		while (headerNames.hasMoreElements()) {
			System.out.println(headerNames.nextElement());
		}
		
		/* request.getHeader()에 name값을 전달해서 값을 가져올 수 있다.*/
		System.out.println("accept : " + request.getHeader("accept"));
		System.out.println("host : " + request.getHeader("host"));
		
		
		response.setContentType("text/html; charset=UTF-8"); //1.응답형식과 응답 받을 문자설정 
		//response.setHeader("Refresh", "1");
		
		PrintWriter out = response.getWriter();
		
		long currentTime = System.currentTimeMillis(); //2.현재 시간을 밀리세컨드로 가져오기 
		
		out.print("<h1>" + currentTime + "</h1>"); 
		//3.html형식을 모두 갖추지 않더라도, 잘 출력이 될 것이다 = <head>~이런게 아니라 <h1>태그만있어도 상관없다는 얘기
		
		out.close();
		//4. 출력하기
		
		/* response header 출력 */
		/* 응답에 대한 헤더 정보 가져오는 방법 */
		Collection<String> responseHeaders = response.getHeaderNames(); //1.header이름 알아보기, collection string type으로 return type
		//Iterator타입의 반복문에서 하나하나의 key값을 가져와서, response.getHeader("원하는값")을 출력할 수 있다.
		Iterator<String> iter = responseHeaders.iterator();
		while(iter.hasNext()) {
			String headerName = iter.next();
			System.out.println(headerName + " : " + response.getHeader(headerName));
		}
		
		
		
		
	}

}
