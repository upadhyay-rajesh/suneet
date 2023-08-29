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

/**
 * Servlet implementation class CheckEmailServlet
 */
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("e1");
		FacebookUser fu=new FacebookUser();
		
		fu.setEmail(email);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		FacebookServiceInterface fs=new FacebookService();
		boolean b=fs.checkEmailService(fu);
		out.println("<html><body>");
		if(b) {
			out.println("<font color=red>Email already exist</font>");
		}
		else {
			out.println("<font color=green>valid</font>");
		}
		out.println("</body></html>");
	}

}
