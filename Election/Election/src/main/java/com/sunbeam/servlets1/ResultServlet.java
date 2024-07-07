package com.sunbeam.servlets1;

import javax.servlet.annotation.WebServlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processhtml(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processhtml(req, resp);
	}
	
	protected void processhtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> candlist = new ArrayList<Candidate>();
		try(CandidateDao canddao = new CandidateDaoImpl()){
			candlist=canddao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Result</title>");
				out.println("</head>");
				out.println("<body>");
				ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("AppTitle");
				out.printf("<h3>%s</h3>", appTitle);
				String Uname = "";
				Cookie [] arr = req.getCookies();
				if(arr != null) {
					for(Cookie c:arr) {
						if(c.getName().equals("uname")) {
							Uname=c.getValue();
						}
					}
				}
				out.printf("Hello, %s<hr/>\n", Uname);
				out.println("<center>");
				out.println("<table  border='1px solid black' width='600px' height='600px'>");
				out.println("<thead>");
				out.println("<th>Id</th>");
				out.println("<th>Name</th>");
				out.println("<th>Party</th>");
				out.println("<th>Votes</th>");
				out.println("<th colspan='2'>Action</th>");
				out.println("</thead>");
				out.println("<tbody>");
				for (Candidate c : candlist) {
					out.println("<tr>");
					out.printf("<td>%d</td>\n", c.getId());
					out.printf("<td>%s</td>\n", c.getName());
					out.printf("<td>%s</td>\n", c.getParty());
					out.printf("<td>%d</td>\n", c.getVotes());
					out.printf("<td><a href='editcand?id=%d'>Edit</a></td>\n",c.getId());
					out.printf("<td><a href='delCand?id=%d'>Delete</a></td>\n",c.getId());
					out.println("</tr>");
				}
				out.println("</tbody>");
				out.println("</table>");
				String msg=(String) req.getAttribute("message");
				if(msg!=null)
				{
					out.println("</br></br>"+ msg);
				}
				out.println("<br/><a href='Announcement.html'>Announcement</a>");
				out.println("<a href='logout'>Sign Out</a>");
				out.println("</center>");
				
				out.println("</body>");
				out.println("</html>");
	}
}
