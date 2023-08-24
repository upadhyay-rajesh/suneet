package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;


public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
	
		
		FacebookUser fu=new FacebookUser();
	
		fu.setPassword(password);
		fu.setEmail(email);
		
		
		FacebookServiceInterface fs=new FacebookService();
		boolean i=fs.loginProfileService(fu);
		
		if(i) {
			
			HttpSession session=request.getSession(true);
			session.setAttribute("userid", email);
			
			//session.setMaxInactiveInterval(2);
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/loginresult.jsp");
			rd.forward(request, response);
			
		}
		else {
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/loginresultfail.jsp");
			rd.forward(request, response);
		}
	}

}
