package com.greedy.section01.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
    	/* 기본 생성자 */
    	System.out.println("FirstFilter 인스턴스 생성!");
    }

	public void destroy() {
		/* 필터 인스턴스가 소멸될 때 호출 되는 메소드 (톰캣 종료 시) */
		System.out.println("filter destory 호출");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* Servlet으로 request가 전달 되기 전에 요청을 가로채는 역할을 하는 메소드 */
		System.out.println("filter doFilter 호출");
		
		/* request, response의 가공을 처리하기 위해서는 여기에 코드를 작성한다 */
		
		/* 위에서 뭔가 처리를 한 뒤 다음 필터 혹은 서블릿의 service(doGet/doPost)를 호출한다. */
		chain.doFilter(request, response);
		
		/* 서블릿에서 처리 후에 다시 수행할 내용이 있으면 작성한다. */
		System.out.println("서블릿 요청 처리 완료!");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		/* 필터 인스턴스가 최초 생성 될 때 호출되는 메소드 */
		System.out.println("filter init 호출");
	}

}
