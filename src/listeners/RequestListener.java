package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {
	public void requestInitialized(ServletRequestEvent request) {
		System.out.println("Request initialized");
	}

	public void requestDestroyed(ServletRequestEvent request) {
		System.out.println("Request destroyed");
	}
}
