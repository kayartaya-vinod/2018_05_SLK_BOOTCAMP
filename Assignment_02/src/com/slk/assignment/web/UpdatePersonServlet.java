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
import com.slk.assignment.entity.Person;

@WebServlet("/update-person")
public class UpdatePersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PersonsDao dao = DaoFactory.getPersonsDao(DaoTypes.JDBC);
			
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			Integer id = new Integer(request.getParameter("id"));
			
			Person p = new Person(fname, lname, email, phone);
			p.setId(id);
			dao.updatePerson(p);
			
			response.sendRedirect("./");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
