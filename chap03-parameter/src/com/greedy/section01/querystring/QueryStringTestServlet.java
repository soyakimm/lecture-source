package com.greedy.section01.querystring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* HttpSevlet 클래스의 service 메소드가 요청 방식에 의해
		 * Get 요청은 doGet() 메소드를 호출하며 request와 response를 전달해준다.
		 * 
		 * service로부터 전달받은 HttpServletRequest는 요청 시 전달한 값을 getParameter() 메소드로 추출해올 수 있다. 
		 * 이 때 인자로 input 태그에 지정한 name 속성의 값을 문자열 형태로 전달해주어야 한다. 
		 * 화면에서 전달한 form 태그 내의 모든 input 태그의 값을 HashMap으로 관리하고 있는데,
		 * 원하는 값을 찾기 위해서는 key 역할을 하는 문자열이 필요하기 때문이다. 
		 * 
		 * key 역할을 하는 문자열이 없을 경우 value 속성은 null로 리턴 된다.
		 */
		
		String name = request.getParameter("name"); //name:key ("name"):value
		System.out.println("이름 : " + name); //value가 없으면 null로 반환
		
		
		/* getParameter() 메소드는 리턴 타입이 문자열 형태임을 잊지말자.
		 * 즉, 숫자를 전달해도 문자열 형태로 전달되므로 숫자로 된 값이 필요하다면 검증 후 parsing 해야 한다. */
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("나이 : " + age);
		
		/* java.sql.Date 타입으로 날짜 데이터 parsing 처리*/
		java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday")); //valueOf메소드로 2022-02-28을 '문자열'로 변형해서 보여줌
		System.out.println("생일 : " + birthday);
		
		/* radio로 전달 된 값은 여러 값 중 한가지만 전달 되기 때문에 parameter로 전달 받은 값을 꺼내기만 하면 된다. */
		String gender = request.getParameter("gender");
		System.out.println("성별 : " + gender);  //radio에서 체크한 value값을 가져올 것.
		
		/* select box를 이용한 방식도 크게 다르지 않음 */
		String national = request.getParameter("national");
		System.out.println("국적 : " + national);
		
		/* 하지만 checkbox는 다중으로 입력 될 수 있기 때문에 선택된 값이 '문자열이 아닌' '문자열 배열'의 형태로 전달
		 * 이때, getParaameterValues() 메소드를 이용하여 문자열 배열 형태로 값을 반환 받을 수 있다. */
		 String[] hobbies = request.getParameterValues("hobbies");
		 
		 for(String hobby : hobbies) {
			 System.out.println("취미 : " + hobby);
		 }
		
		
	}

}
