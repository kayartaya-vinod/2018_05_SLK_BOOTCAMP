package com.slk.training.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
				request.setAttribute("heading", "List of all contacts");
			}
			else {
				list = dao.getContactsFromCity(city);
				request.setAttribute("heading", "List of contacts from city: " + city);
			}

			// store the "list" in a place where other servlets/JSPs can access
			request.setAttribute("contacts", list);
			
			
			// forward the control to the view (JSP/Servlet)
			// RequestDispatcher instance know how to invoke the service function 
			// of the JSP/Servlet
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/contact-list.jsp");
			rd.forward(request, response);
			
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}









