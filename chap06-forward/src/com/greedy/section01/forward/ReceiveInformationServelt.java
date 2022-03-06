package com.greedy.section01.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ReceiveInformationServelt extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
		
		
		/*위에서 요청 정보를 받았고 모든 비즈니스 로직은 성공이라는 가정 하에 
		  user01을 입력 시 해당 아이디를 이용해 user01님 환영합니다 라는 메세지를 출력해주는 화면을 만들자 
		  만드는 방법: PrintLoginSuccessServlet으로 위임하기 위해서는 RequestDispatcher 인스턴스 생성 후 
		  forward 메소드를 이용해서 요청과 응답에 대한 정보를 전달한다.
		  이 때 다른 서블릿으로 요청하기 위한 데이터는 request에 setAttribute로 전달하여 받는 쪽에서는 getAttribute를 이용해 꺼내서 사용한다.
		  */
		
		/*위임전에 전달하고 싶은 속성이 있다면, Attribute로 데이터를 설정하면 다른 영역에서 꺼내서 사용 가능*/
		request.setAttribute("userId", userId);
		
		RequestDispatcher rd = request.getRequestDispatcher("print"); 
		/*return type: ReuqestDispatcher(서블릿 하위 패키지) | 위임할 (path:경로) 설정 | 상대적 경로 작성필요 */
		
		/* 위임 받은 것을 처리 하는 forward */
		rd.forward(request, response);
		
		
		
	}

}
