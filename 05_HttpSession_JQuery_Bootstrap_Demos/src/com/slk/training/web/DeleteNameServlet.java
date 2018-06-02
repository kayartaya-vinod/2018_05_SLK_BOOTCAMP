package com.slk.training.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-name")
public class DeleteNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String>names =(List<String>) request.getSession().getAttribute("friendNames");
		if(names!=null) {
			String input = request.getParameter("index");
			if(input!=null) {
				try {
					int index = Integer.parseInt(input);
					names.remove(index);
				} catch (NumberFormatException e) {
				}
			}
		}
		response.sendRedirect("./index.jsp");
	}

}
