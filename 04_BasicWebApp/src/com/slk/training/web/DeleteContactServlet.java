package com.slk.training.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoFactory;

@WebServlet("/delete-contact")
public class DeleteContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String strId = req.getParameter("id");
			try {
				int id = Integer.parseInt(strId);
				ContactsDao dao = DaoFactory.getContactsDao("jdbc");
				dao.deleteContact(id);
			} catch (RuntimeException e) {
			}
			resp.sendRedirect("./get-contacts-from-city");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
