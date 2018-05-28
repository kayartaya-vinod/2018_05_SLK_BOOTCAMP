package com.slk.assignment.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.assignment.dao.DaoFactory;
import com.slk.assignment.dao.DaoTypes;
import com.slk.assignment.dao.PersonsDao;

@WebServlet("/delete-person")
public class DeletePersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PersonsDao dao = DaoFactory.getPersonsDao(DaoTypes.JDBC);
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deletePerson(id);
			
			response.sendRedirect("./");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
