package com.slk.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/greeting", "/greet" })
public class GreetingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("./index.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		if (username.trim().length() == 0) {
			username = "friend";
		}
		String color = req.getParameter("color");
		String[] genres = req.getParameterValues("genre");

		String message = String.format("<h1 style=\"color:%s\">Hello, %s!</h1>", 
				color, username);
		
		message += "Your choice of movies are: ";
		if (genres != null && genres.length > 0) {
			message += "<ul>";
			for (String genre : genres) {
				message += "<li>" + genre + "</li>";
			}
			message += "</ul>";
		} else {
			message += "None :-(";
		}

		PrintWriter out = resp.getWriter();
		out.println(message);
		out.close();
	}

}
