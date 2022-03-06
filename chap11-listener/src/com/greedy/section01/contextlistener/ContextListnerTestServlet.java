package com.greedy.section01.contextlistener;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/context")
public class ContextListnerTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("context listener 확인용 서블릿");
		
		ServletContext context = request.getServletContext();
		
		/*값 추가 = setAttribute*/
		/* context에 attr를 추가하면 attributeAdded() 메소드가 동작한다. */
		context.setAttribute("test", "value");
	
		/* 동일한 key로 context에 attr 추가(수정)하면 attributeReplaced() 메소드가 동작한다.*/
		context.setAttribute("test", "value2");
			
		/* context에서 attr을 제거하면 attributeRemoved() 메소드가 동작한다. */
		context.removeAttribute("test");
	}

}
