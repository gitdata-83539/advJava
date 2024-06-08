package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

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
			candlist=canddao.getCandidatewiseVotes();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted</title>");
		out.println("</head>");
		out.println("<body>");
		String name = "";
		Cookie []carr = req.getCookies();
		if(carr != null) {
			for(Cookie c:carr) {
				if(c.getName().equals("usrname")) {
					name=c.getValue();
				}
			}
		}
		out.printf("<h4>Hello %s</h4>\n",name);
		out.println("<table>");
		out.println("<tr> Name Party Votes Actions </tr>");
		if(candlist.size() != 0) {
			for(Candidate c:candlist) {
				out.println("<tr>");
				out.printf("<td> %s %s %d</h3> <a href='edit'>Edit</a> <a href='delete'>Delete</a><td>", c.getName(),c.getParty(),c.getVotes());
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("<br/><br/><a href='logout'>Logout</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
