package com.tap.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logOut")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    // Get the session
		
	    HttpSession session = request.getSession(false); // 'false' means do not create a new session if not exists

	    // Invalidate the session if it exists
	    if (session != null ) {
	    	String ob1=(String)(session.getAttribute("EMAIL")); 
		    System.out.println("sessionclos.........."+ob1);
		    session.invalidate();
		    }
		
	    // Redirect to the home page after logout
	    return "/WEB-INF/signin.jsp";
	}

}
//https://www.digitalocean.com/community/tutorials/java-session-management-servlet-httpsession-url-rewriting

