package com.greedy.section01.jsonstring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/receive/json")
public class ReceiveJsonStringServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* ajax 응답은 단 한번의 문자열 응답만 할 수 있다.
		 * 따라서, 여러 개의 값을 전달하기 위해서는 특수한 방법을 이용한다.
		 * java에서 이용하는 object는 javascript에서 이해할 수 없다.
		 * 따라서 자바스크립트에서 이해할 수 있는 object 타입으로 변환을 해 주어야 한다.
		 * 이 때 json이라는 object타입으로 변환할 수 있는 문자열 형태로 가공하여 응답을 해주게 되면
		 * javascript에서 object로 취급할 수 있다.
		 * 그럼 규칙은 뭘까?
		 * json 데이터 규칙은 key와 value를 ':'로 구분하며, 여러 개 key value set은 ','로 구분한다.
		 * 이 때 키는 문자열 형태로 ""로 감싸져야 하며, 문자열에 해당하는 값 또한 ""로 감싸져야 한다.
		 */
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();	//출력스트림을 통해서 응답
		//새로운 페이지를 원하는 것이 아니라, 같은 페이지에서 데이터만 뽑는것이기 때문에 stream을 이용
		out.print("{\"type\":\"get\",\"firstName\":\"soyeong\",\"lastName\":\"kim\",\"age\":20}");
		
		out.flush();
		out.close();
	}

}
