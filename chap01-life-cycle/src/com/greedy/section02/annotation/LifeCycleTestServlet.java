package com.greedy.section02.annotation;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/* loadOnStartup에 우선 순위를 지정하면(낮을 수록 우선 순위가 높다) 서버가 start 될 때 인스턴스를 생성하고 init()을 호출 */
@WebServlet(value="/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTestServlet extends HttpServlet{
	/* 메소드의 호출 횟수를 카운트 하기 위한 용도의 필드 */
	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;
	
	
	/* 서블릿의 요청이 최초인 경우 한 번 동작하는 메소드 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("annotation 매핑 init() 메소드 호출 : " + initCount++);
	}
	
	
	/* 서블릿 컨테이너에 의해 호출 되며 최초 요청시에는 init() 이후에 동작하고, 두 번째 요청부터는 바로
	 * service()를 호출 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException{
		System.out.println("annotation 매핑 service() 메소드 호출 : " + serviceCount++);
	}
	
	/* 컨테이너가 종료 될 때 호출 되는 메소드이며 주로 자원을 반납하는 용도로 사용 */
	@Override
	public void destroy() {
		System.out.println("annotation 매핑 destory() 메소드 호출 : " + destroyCount++);
	}
	
}
