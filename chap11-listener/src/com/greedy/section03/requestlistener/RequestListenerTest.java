package com.greedy.section03.requestlistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

    public RequestListenerTest() {
    	/* context가 로드 될 때 생성자 호출하여 인스턴스는 생성된다.*/
    	System.out.println("request listener인스턴스 생성");
    }



    public void requestInitialized(ServletRequestEvent sre)  { 
    	/* request 가 생성 될 때 호출 됨 */
    	System.out.println("request init!!");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	/* request 가 소멸 될 때 호출 됨 */
    	System.out.println("request destroyed!!");
    }
    
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	/* reqeust에 attribute가 추가 될 때 호출 됨*/
    	System.out.println("request attribute added");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	/* reqeust에 attribute가 수정 될 때 호출 됨*/
    	System.out.println("request attribute Replaced");
    }
	
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	/* reqeust에 attribute가 삭제 될 때 호출 됨*/
    	System.out.println("request attribute Removed");
    }
}
