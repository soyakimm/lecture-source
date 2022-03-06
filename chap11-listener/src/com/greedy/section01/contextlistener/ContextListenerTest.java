package com.greedy.section01.contextlistener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

	/* 리스너는 특정 이벤트 행위가 동작하는 경우, 컨테이너에 의해 호출되는 메소드들을 인터페이스에 정의해두었다.
	 * 이를 상속 받아 구현한 메소드가 특정 이벤트가 시작하는 경우 필요한 로직을 작성하게 되는데
	 * 크게 3가지 범주의 이벤트로 구분한다.
	 * 1. context
	 * 2. session
	 * 3. request
	 */
    public ContextListenerTest() {
    	/* context가 생성 될때 변화를 감지하는 Listener 인스턴스가 함께 생성한다 */
    	System.out.println("context listener 인스턴스 생성");
    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	/* context에 attribute가 추가 될 때 동작한다. */
    	System.out.println("context attribute added!!");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	/* context에 attribute가 제거 될 때 동작한다. */
    	System.out.println("context attribute removed!! ");
    }


    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	/* context에 attribute가 수정 될 때 동작한다. */
    	System.out.println("context attribute replaced!!");
    }

    
    public void contextInitialized(ServletContextEvent sce)  {
    	/* context가 최초 생성될 때 생성자 호출 이후 동작하는 메소드이다. */
    	System.out.println("context init!!!");
    	
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	/* context가 소멸할 때 동작한다.*/
    	System.out.println("context destroy!!");
    }
}
