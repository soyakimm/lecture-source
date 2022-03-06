package com.greedy.section02.uses;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/* 어노테이션을 빼고, xml쪽에 필터 등록을 해보자*/
public class EncodingFilter implements Filter {

	private String encodingType;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		/* (2) 이 코드를 통과할때, 인코딩이 되도록 한다  */
		HttpServletRequest hrequest = (HttpServletRequest) request;
		if("POST".equals(hrequest.getMethod())) {
			request.setCharacterEncoding(encodingType);
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		/* (1) xml에서 설정한 init-param의 key를 이용하여 fConfig에서 값을 꺼내올 수 있다. */
		encodingType = fConfig.getInitParameter("encoding-type");
	}

}
