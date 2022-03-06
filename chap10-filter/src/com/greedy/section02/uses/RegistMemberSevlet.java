 package com.greedy.section02.uses;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@WebServlet("/member/regist")
public class RegistMemberSevlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 출력을 했을때
		 * 1. post로 전달할때는 인코딩이 깨진다. 
		 * 2. 비밀번호는 보여지는 평문으로 다루면 안되고, 암호화처리를 해주어야 한다. 
		 * */
		
		/* 1. 인코딩 필터
		 * 2. 암호화 필터
		 */
		
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
		System.out.println("name : " + name);
		
		
		/* 암호화 처리된 패스워드는 동일합 값이 입력되더라도 매번 실행시마다 다른 값을 가지게 된다.
		 * 그럼 나중에 DB에 이 상태로 기록하게 되면 가입 된 회원정보로 로그인 할 때 비밀번호가 같은지 어떻게 비교할까?
		 * 암호화 된 문자열은 일반 문자열 비교가 불가능하고 matches()라는 메소드를 이용해야 한다.
		 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/* passwordEncoder.matches : 패스워드가 일치하냐?
		 * rawPassword : 입력되는 문자열 그대로
		 * encodedPassword : 변수값
		 */
		System.out.println("비밀번호가 pass01인지 확인 : " + passwordEncoder.matches("pass01", password));
		System.out.println("비밀번호가 pass02인지 확인 : " + passwordEncoder.matches("pass02", password));
		
	}

}
