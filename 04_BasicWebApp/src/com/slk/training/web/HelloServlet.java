package com.slk.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Tomcat calls this overridden init() when the instance of this class
	// is loaded into the container
	public void init(ServletConfig config) throws ServletException {
		System.out.println("HelloServlet.init() called");
		super.init(config);
	}

	// Tomcat calls this overridden destroy() method when this instance is
	// removed from the container (typically happens when Tomcat is shutdown)
	public void destroy() {
		System.out.println("HelloServlet.destroy() called");
	}

	// Tomcat calls the contract service() method which is implemented in the
	// HttpServlet class, which in turn calls another service() method by
	// passing HTTP variants of the ServletRequest and ServletResponse as
	// parameters. This http version of the service() method checks for the
	// request's HTTP method (GET, POST etc) and calls the respective
	// doXxx() methods.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HelloServlet.doGet() called");

		PrintWriter out = response.getWriter();
		out.println("<h1>Hello, world!</h1>");
		out.close();

	}

}
