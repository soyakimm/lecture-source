package com.greedy.section02.uses;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/* member 서비스인 경우에만 암호화 처리 할 수 있도록 한다. */
@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {

	/* 기능적인 부분 실행 : doFilter */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		RequestWrapper wrapper = new RequestWrapper(hrequest);
		
		
		chain.doFilter(wrapper, response); /*여러개 필터들이 체인으로 연결되어, doFilter을 호출 -> 다음 필터 호출 -> 없으면 서블릿 호출 */ 
	}

	
}
