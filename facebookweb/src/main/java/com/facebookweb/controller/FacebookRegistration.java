package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;


public class FacebookRegistration extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		FacebookServiceInterface fs=new FacebookService();
		int i=fs.createProfileService(fu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body bgcolor=pink><center><font size=6 color=red>");
		if(i>0) {
			out.println("<br><br><br><br><br><br>profile created successfully. <br> to continue <a href=signin.html>Click Here</a>");
			
		}
		out.println("</font></center></body></html>");
	}

}
