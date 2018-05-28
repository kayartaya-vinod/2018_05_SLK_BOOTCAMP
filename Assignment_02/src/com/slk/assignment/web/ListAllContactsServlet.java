package com.slk.assignment.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.assignment.dao.DaoException;
import com.slk.assignment.dao.DaoFactory;
import com.slk.assignment.dao.DaoTypes;
import com.slk.assignment.dao.PersonsDao;

public class ListAllContactsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PersonsDao dao = DaoFactory.getPersonsDao(DaoTypes.JDBC);
			request.setAttribute("persons", dao.getAll());
			request.getRequestDispatcher("/WEB-INF/views/list-persons.jsp")
				.include(request, response);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
		
	}
}





