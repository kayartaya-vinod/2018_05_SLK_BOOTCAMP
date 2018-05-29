package com.slk.training.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/store-name")
public class StoreNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./index.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String friendName = request.getParameter("friend_name");

		// request.getSession() checks if a cookie called "JSESSIONID" is present
		// in the request and if yes, then it returns a session object represented
		// by the session id found in the cookie. Else, a new session object is
		// created and returned.
		HttpSession session = request.getSession();
		List<String> friendNames = (List<String>) session.getAttribute("friendNames");
		if (friendNames == null) {
			friendNames = new ArrayList<String>();
			session.setAttribute("friendNames", friendNames);
		}

		friendNames.add(friendName);

		response.sendRedirect("./index.jsp");
	}

}
