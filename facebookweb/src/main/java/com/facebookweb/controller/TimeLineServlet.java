package com.facebookweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.TimeLine;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

/**
 * Servlet implementation class TimeLineServlet
 */
public class TimeLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String email=ss.getAttribute("userid").toString();
		
		FacebookUser fu=new FacebookUser();
	
		fu.setEmail(email);
		
		
		FacebookServiceInterface fs=new FacebookService();
		List<TimeLine> timelinemessage=fs.timelineService(fu);
		
		request.setAttribute("result", timelinemessage);
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/timelineresult.jsp");
		rd.forward(request, response);
	}

}













