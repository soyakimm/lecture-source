package com.greedy.section02.formdata;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* post방식으로 전달 받은 데이터에 한글이 있는 경우 한글 값이 깨져서 보인다.
		 * GET 방식의 데이터는 HTML charset에 기술 된 인코딩 방식으로 브라우저가 한글을 이해한 뒤
		 * %문자로 URLEncoder를 이용하여 변환 후 url 요청으로 전송한다. 
		 * 이 때 헤더의 내용은 알맞게 해석 되어, 별도의 charset 설정이 필요 없다.
		 * (GET 요청은 보통 서버 쪽 리소스를 가져오는 용도의 행위를 요청하는 http 요청 방식이기 때문에 별도의 데이터가 
		 *  필요 없어서 요청 본문-body-는 해석하지 않게 된다.)
		 *  
		 *  하지만 POST 요청은 서버쪽 리소스에 내용을 추가하는 용도의 요청이기 때문에 요청하는 데이터가 필요한 경우가 많다. 
		 *  이러한 정보를 요청 본문에 key&value 방식으로 담아 전송하는데, 헤더와는 별개로 URLEncoder를 이용하지 않고 meta에 기술된
		 *  charset에 따라 UTF-8로 해석된 데이터를 서버로 전송하게 된다. 
		 *  request.getCharacterEncoding()을 호출해보면 null을 반환하는데, 
		 *  인코딩 된 방식을 명시해주지 않으면 기본 ISO-8859-1로 해석하게 되어 값을 꺼내오면 글자가 깨지는 현상이 발생한다.
		 *  이 때, parameter를 꺼내오기 전에 parameter 값을 해석할 인코딩 방식이 UTF-8임을
		 *  setCharacterEncoding(String encType)으로 지정해주면 브라우저 요청 인코딩 방식과 일치하게 되어
		 *  한글 깨짐 현상을 막을 수 있다. 
		 *  
		 */
		
		/*Encoding set알아보기*/
		System.out.println(request.getCharacterEncoding()); // 출력결과 => null : 기본설정이 없음
		
		/* 파라미터 값을 꺼내기 전에 디코딩할 인코딩 방식을 지정해주면 해당 방식으로 본문의 값을 해석한다. */
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		
		
		/* 인코딩을 제외한 나머지 값들은 GET방식에서 값을 꺼내온 것과 동일하다. */
		
		/* 만약 클라이언트 쪽에서 요청한 데이터의 key와 value를 일일히 확인하기 힘들다면
		 * 모든 데이터의 key를 이용하여 전송 된 값들을 일괄 처리할 수도 있다. */
		Map<String, String[]> requestMap = request.getParameterMap();
		/* Map의 순차적 접근 : Set으로 만들고 -> Iterator로 뽑기 */
		Set<String> keySet = requestMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next(); //key값
			String[] value = requestMap.get(key); //value값 - return타입: 배열
			
			System.out.println("key : " + key);
			for(int i = 0; i < value.length; i++) {
				System.out.println("value[" + i + "] : " + value[i]);
			}
		}
		
		/* 파라미터로 전달 된 키 목록만도 확인할 수 있다.
		 * request.getParameterNames()를 이용한다.
		 */
		
		Enumeration<String> names = request.getParameterNames();
		
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
