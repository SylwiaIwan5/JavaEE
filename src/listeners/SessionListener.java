package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent session) {
		System.out.println("Session created " + session.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent session) {
		System.out.println("Session destroyed");
	}
}
