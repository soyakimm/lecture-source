package com.greedy.section02.uses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper{

	//매개변수 생성자 생성 (상위타입이 아니라 다운캐스팅한 HttpServletRequestWrapper를 상속받기 때문에)
	/* 부모 쪽에 기본 생성자가 존재하지 않기 때문에 request를 전달해주는 생성자가 필요하다. */
	public RequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override //파라미터를 꺼내오는 메소드를 재정의
	public String getParameter(String key) { 
//		System.out.println("호출 되는지 확인");
//		return null;
		
		String value = "";
		if("password".equals(key)) {
			/* 랜덤 솔팅 기법을 적용한 다이제스트 생성을 지연시킨 단방향 해시 암호화 알고리즘 */
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key));
		} else {
			value = super.getParameter(key);
		}
		
		return value;
	}

}
