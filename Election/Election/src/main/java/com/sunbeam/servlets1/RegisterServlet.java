package com.sunbeam.servlets1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String dob=req.getParameter("dob");
		Date d=Date.valueOf(dob);
		String role=req.getParameter("role");
		User u=new User(firstName,lastName,email,password,d,role);
		try {
			UserDao udao=new UserDaoImpl();
			int n=udao.save(u);
			if(n>0)
			{
				resp.setContentType("text.html");
				PrintWriter out=resp.getWriter();
				out.println("<html>");
				out.println("<h3>Registered Successfully</h3>");
				out.println("</html>");
				resp.sendRedirect("index.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
