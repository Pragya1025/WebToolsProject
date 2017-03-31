package com.neu.edu.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout.htm")
public class LogoutController {

	@RequestMapping(method=RequestMethod.GET)
	 public void handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {      
		 String value = hsr.getParameter("action");
		 	
	       		HttpSession session = hsr.getSession();
	       		session.invalidate();
	            RequestDispatcher rd = hsr.getRequestDispatcher("index.jsp");
	             rd.forward(hsr, hsr1);
	       
	}
}
