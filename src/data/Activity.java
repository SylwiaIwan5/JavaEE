package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/activity")
public class Activity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VISIT_COUNTER_ATTRIBUTE = "VISIT_COUNTER";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("JSP/ActivityForm.jsp").forward(request, response);
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10);
		session.removeAttribute(VISIT_COUNTER_ATTRIBUTE);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"");
		
		String givenFirstName = request.getParameter("firstName");
		String selectedActivity = request.getParameter("activity");
		
		String cookieFirstNameName = "FIRST_NAME";
		String cookieSelectedActivityName = "ACTIVITY";
		
		Cookie cookieFirstName = new Cookie(cookieFirstNameName, givenFirstName);
		Cookie cookieSelectedActivity = new Cookie(cookieSelectedActivityName, selectedActivity);
		
		cookieFirstName.setMaxAge(10);
		cookieSelectedActivity.setMaxAge(10);
		
		response.addCookie(cookieFirstName);
		response.addCookie(cookieSelectedActivity);
		
		PrintWriter responseWriter = response.getWriter();
		
		responseWriter.write("<html><head><meta charset=\"UTF-8\"><link rel=\"stylesheet\""
				+ "href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\""
				+ "integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\"" 
				+ "crossorigin=\"anonymous\">" + "<title>Selected activity</title></head><body>"
				+ "<h3><div class=\"alert alert-primary\" role=\"alert\">" + givenFirstName
				+ ", so let's " + selectedActivity + "!</div></h3>");
		
		Cookie[] cookies = request.getCookies();
		responseWriter.println("<div class=\"alert alert-primary\" role=\"alert\">"
				+ "<h5>Information about Request Cookies:</h5>");
		for(Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			String name = cookie.getName();
			String value = cookie.getValue();
			responseWriter.println("<p>" + name + ": " + value +"</p>");
		}
		responseWriter.write("</div>");
		
		HttpSession session = request.getSession();
		responseWriter.println("<div class=\"alert alert-primary\" role=\"alert\">"
				+ "<h5>Information about Session Attributes:</h5>");
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
		String attributeName = attributeNames.nextElement();
			    responseWriter.write("<p>" + attributeName + ": " + session.getAttribute(attributeName) + "</p>");
		    }
		
		responseWriter.write("</div></body></html>");
		increaseVisitCounter(session);
	}
	
	private void increaseVisitCounter(HttpSession session) {
	    Object counter = session.getAttribute(VISIT_COUNTER_ATTRIBUTE);
	    Integer numberOfVisits;
	    if (counter != null) {
	    	numberOfVisits = (Integer) counter + 1;
	    }
	    else {
	    	numberOfVisits = 1;
	    }
	    session.setAttribute(VISIT_COUNTER_ATTRIBUTE, numberOfVisits);
    }
}
