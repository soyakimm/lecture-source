package com.greedy.section01.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Enumeration<String> attrName = request.getAttributeNames();
		while(attrName.hasMoreElements()) {
			System.out.println(attrName.nextElement());
		}
		
		String forwardRequestURL = (String)request.getAttribute("javax.servlet.forward.request_uri");
		//javax.servlet.forward.request_uri가 가지고 있는 속성을 가지고 온다.
		String contextPath = (String)request.getAttribute("javax.servlet.forward.context_path");
		String servletPath = (String)request.getAttribute("javax.servlet.forward.servlet_path");
		Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
		String errorMessage = (String)request.getAttribute("javax.servlet.error.message");
		String servletName = (String)request.getAttribute("javax.servlet.error.servlet_name");
		String errorRequestURI = (String)request.getAttribute("javax.servlet.error.request_uri");
		
		System.out.println("forwardRequestURI : " + forwardRequestURL);
		System.out.println("contextPath: " + contextPath);
		System.out.println("servletPath: " + servletPath);
		System.out.println("statusCode: " + statusCode);
		System.out.println("errorMessage: " + errorMessage);
		System.out.println("servletName: " + servletName);
		System.out.println("errorRequestURI: " + errorRequestURI);
		
		
		StringBuilder errorPage = new StringBuilder();
		errorPage.append("<doctype html>\n")
				 .append("<html>\n")
				 .append("<head>\n")
				 .append("</head>\n")
				 .append("<body>\n")
				 .append("<h1 aling='center'>")
				 .append(statusCode)
				 .append("  -  ")
				 .append(errorMessage)
				 .append("</h1>\n")
				 .append("</body>\n")
				 .append("</html>\n");

		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(errorPage.toString());
		
		out.flush(); // 출력 코드
		out.close(); // 출력 닫아주기
		
		
		
		
		
	}

}
