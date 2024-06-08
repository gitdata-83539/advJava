package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processhtml(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processhtml(req, resp);
	}
	
	protected void processhtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		try(UserDao userdao = new UserDaoImpl()){
			User usr = userdao.findByEmail(email);
			if(usr != null && password.equals(usr.getPassword())) {
				String uname=usr.getFirstName()+"-"+usr.getLastName();
				Cookie c = new Cookie("usrname",uname);
				c.setMaxAge(3600);
				resp.addCookie(c);
				if(usr.getRole().equals("voter")) {
					resp.sendRedirect("showcand");
				}
				else {
					resp.sendRedirect("result");
				}
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Invalid User name or password</h2> <br/> <br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
