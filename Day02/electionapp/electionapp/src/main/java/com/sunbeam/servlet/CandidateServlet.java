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

public class CandidateServlet extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processhtml(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processhtml(req, resp);
	}
	
	protected void processhtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> candlist= new ArrayList();
		try(CandidateDao canddao = new CandidateDaoImpl()){
			candlist = canddao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidates</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Give your Vote</h3> <br/><br/>");
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
		out.println("<form method='get' action='vote'>");
		for(Candidate c :candlist) {
			out.printf("<input type='radio' value='%d' name='candidate'/> %s (%s) <br/> \n",c.getId(),c.getName(),c.getParty());
		}
		out.println("<input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
