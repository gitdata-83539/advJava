package com.sunbeam.servlets1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
//import org.apache.tomcat.util.http.parser.Cookie;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateServlet extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> l= new ArrayList<Candidate>();
		try {
			CandidateDao cdao= new CandidateDaoImpl();
			l= cdao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		ServletContext Ctxapp=this.getServletContext();
		String appTitle=Ctxapp.getInitParameter("AppTitle");
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
		ServletContext ctx= req.getServletContext();
		String msg=(String)ctx.getAttribute("announcement");
		if(msg!=null)
		{
			out.printf("Announcement: %s<br/><br/>\n", msg);
		}
		out.println("<form method='post' action='vote'>");
		for(Candidate c: l)
		{
			out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n",c.getId(),c.getName(),c.getParty());
			
		}
		out.println("<input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		}
}
