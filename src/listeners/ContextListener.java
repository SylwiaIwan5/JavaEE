package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent context) {
		System.out.println("Application start");
	}

	public void contextDestroyed(ServletContextEvent context) {
		System.out.println("Application ended");
	}
}
