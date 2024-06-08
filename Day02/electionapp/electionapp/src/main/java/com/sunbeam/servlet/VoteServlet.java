package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class VoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processhtml(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processhtml(req, resp);
	}
	
	protected void processhtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String candidateid = req.getParameter("candidate");
			int id = Integer.parseInt(candidateid);
			try(CandidateDao canddao = new CandidateDaoImpl()){
				canddao.incrementVote(id);
			}catch(Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			resp.setContentType("text/html");
			PrintWriter out =resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Voted</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>You Voted Sucessfully</h3> <br/> <br/>");
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
			out.println("<a href='logout'>Logout</a>");
			out.println("</body>");
			out.println("</html>");
	}
}
