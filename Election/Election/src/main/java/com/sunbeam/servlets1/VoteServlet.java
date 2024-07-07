package com.sunbeam.servlets1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class VoteServlet extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String candidateId = req.getParameter("candidate");
			int id= Integer.parseInt(candidateId);
			try {
				CandidateDao candDao= new CandidateDaoImpl();
				candDao.incrementVote(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Voted</title>");
					out.println("</head>");
					out.println("<body>");
					ServletContext app = this.getServletContext();
					String appTitle = app.getInitParameter("AppTitle");
					out.printf("<h3>%s</h3>", appTitle);
					String userName = "";
							Cookie[] arr = req.getCookies();
							if(arr != null) {
								for (Cookie c : arr) {
									if(c.getName().equals("uname")) {
										userName = c.getValue();
										break;
									}
								}
							}
							out.printf("Hello, %s<hr/>\n", userName);
					out.println("Your vote is registerd successfully. <br/><br/>");
					out.println("<a href='logout'>Sign Out</a>");
					out.println("</body>");
					out.println("</html>");
		}
	
}
