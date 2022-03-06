package com.greedy.section03.status;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/status")
public class StatusCodeTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
//		response.sendError(404); //1. input값만 입력(=값만 입력) 
//		response.sendError(404, "메세지 입력 가능합니다. 없는 페이지 입니다. 경로를 확인해주세요."); //2. 두번째 인자에 '메세지창에 뜰 메세지를 설정'할 수 있다.
		response.sendError(500, "서버 내부 오류입니다. 서버 오류는 개발자의 잘못이고, 개발자는 여러분입니다."); //3. 505: 서버 내부에서 일어난 오류 | 동일하게 에러발생창이 뜬다.
		
	
	
	
	
	}
	


}
