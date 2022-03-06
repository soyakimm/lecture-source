package com.greedy.section01.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 서블릿이 하는 역할은 크게 3가지라고 볼 수 있다. == JDBC의 Controller의 역할
		 * 1. 요청 받기(HTTP method GET/POST 요청에 따른 parameter로 전달 받은 데이터를 꺼내올 수 있다)
		 * 2. 비즈니스 로직 처리(DB 접속과 CRUD에 대한 로직 처리 -> 서비스를 호출하는 쪽으로 해결(MVC))
		 * 3. 응답하기 (문자열로 동적인 웹(HMTL 태그)페이지를 만들어서 스르팀을 이용하여 내보내기)
		 */
		
		
		/* 기본 값은 text/plain이지만 html 태그를 사용하면 요청 시 text/html도 응답으로 수락 가능하도록 
		 * 헤더 설정이 되어 있기 때문에 text/html로 인식 하게 된다.
		 * 하지만 명시적으로 text/plain으로 설정하게 되면 html 태그를 태그로 인식하지 않고 문자열로 인식하게 된다.
		 */
		//response.setContentType("text/plain");
		response.setContentType("text/html");
		
		/* 응답 시에도 별도로 인코딩을 지정하지 않으면 기본적으로 설정 된 인코딩 방식을 따르게 된다. (ISO-8859-1)
		 * 따라서 한글로 페이지를 응답하는 경우 글씨가 깨져서 나오게 된다. 
		 */
		System.out.println("default response encoding : " + response.getCharacterEncoding()); //response의 기본 인코딩 설정값이 무엇인지 확인해보자.
		
		/* 이때 응답할 인코딩 방식이 UTF-8임을 응답 헤더에 알려주게 되면 브라우저가 이를 해석할 때 UTF-8로 인식하고 해석하게 된다. 
		 * 즉, 한글 값이 깨지지 않고 잘 출력된다. */
		
		/* ★주의점★ : getWriter()로 스트림을 얻어오기 전에, encoding 설정을 해주어야 한다 */
		
		response.setCharacterEncoding("UTF-8"); //response가 가지고 setCharacterEncoding으로 encoding을 설정
		System.out.println("changed response encoding : " + response.getCharacterEncoding()); //실질적으로 통신될때 UTF-8로 출력 -> 한글값 올바르게 출력
		
		
		/* ■ 위의 두개의 인코딩 설정(html:응답형식/글자:응답받을 문자)한번에 설정 가능하다 */
		//response.setContentType("text/html; charset=UTF-8");
		
		
		/* 사용자 브라우저에 응답하기 위해 HttpServletResponse가 가지는 getWriter() 메소드로 PrintWriter 인스턴스를 반환 받는다. 
		 * PrintWriter는 BufferedWriter와 형제격인 클래스이지만 더 많은 형태의 생성자를 제공하고 있어, 실제로는 범용성으로 인해 더 많이 사용된다.*/
		PrintWriter out = response.getWriter(); //response로부터 얻어오는 stream (getWriter)
		//원래 1byte 인데, '문자기준'으로 출력을 하면, 자동으로 1byte로 변환해서 전달하게 한다. 
		
		
		/* 문자열을 이용해 사용자에게 내보내기를 할 페이지를 작성한다. */
		StringBuilder responseBuilder = new StringBuilder(); 
		responseBuilder.append("<!doctype html>\n") //appned를 이용해, html형식을 갖추고 '안녕 ser~'를 응답해보자//
						.append("<html>\n")
						.append("<head>\n")
						.append("</head>\n")
						.append("<body>\n")
						.append("<h1>안녕 servlet response</h1>\n")
						.append("</body>\n")
						.append("</html>");
		
		/* 스트림을 이용해 내보내기 */
		out.print(responseBuilder.toString()); //appned 해놓은 모든 값을 string으로 바꿔 출력하게 한다.
		
		/* 버퍼에 잔류한 데이터를 강제로 내보낸다 */
		out.flush();
		
		/*스트림을 닫아준다*/
		out.close();
		
		
		
		
	}


}
