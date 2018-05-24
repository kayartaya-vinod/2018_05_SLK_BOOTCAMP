package com.slk.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.dao.DaoFactory;
import com.slk.training.entity.Contact;

@WebServlet("/get-contacts-from-city")
public class GetContactsFromCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			ContactsDao dao = DaoFactory.getContactsDao("jdbc");
			String city = request.getParameter("city");
			List<Contact> list;
			
			if(city==null || city.trim().length()==0) {
				list = dao.getAll();
			}
			else {
				list = dao.getContactsFromCity(city);
			}
			
			PrintWriter out = response.getWriter();
			out.printf("<h1>Contacts from city '%s' are</h1>", city);
			out.println("<ol>");
			for(Contact c: list) {
				out.printf("<li>%s (%s, %s)</li>", 
						c.getFirstname(), c.getEmail(), c.getPhone());
			}
			out.println("</ol>");
			out.close();
			
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}









