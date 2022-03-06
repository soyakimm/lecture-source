package com.greedy.section02.sessionlistener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListenerTest() {
    	/* context가 로드될 시 인스턴스는 생성된다. */
    	System.out.println("session listener 인스턴스 생성");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	/* 세션이 생성 될 때 동작한다. */
    	System.out.println("session created!!");
    	System.out.println("생성 된 session id : " + se.getSession()); 
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	/* 세션이 만료될 시 동작한다. */
    	System.out.println("session destroyed!!");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("session attrubute added!!");
    	System.out.println("session에서 추가 된 attr : " + se.getName() + ", " + se.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("session attrubute Removed!!");
    	System.out.println("session에서 제거 된 attr : " + se.getName() + ", " + se.getValue());
    	
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("session attrubute Replaced!!");
    	System.out.println("session에서 수정 된 attr : " + se.getName() + ", " + se.getValue());

    }
	
}
