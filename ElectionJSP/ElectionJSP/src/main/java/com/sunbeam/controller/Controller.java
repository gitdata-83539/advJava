package com.sunbeam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ctl")
public class Controller extends HttpServlet{
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String page=req.getParameter("page");
			String uri="/WEB-INF/pages/index.jsp";
			if(page.equals("index"))
				uri ="/WEB-INF/pages/index.jsp";
			else if(page.equals("newuser"))
				uri="/WEB-INF/pages/newuser.jsp";
			else if(page.equals("loginBeans"))
				uri="/WEB-INF/pages/loginBeans.jsp";
			else if(page.equals("register"))
				uri="/WEB-INF/pages/register.jsp";
			else if(page.equals("newuser"))
				uri="/WEB-INF/pages/newuser.jsp";
			else if(page.equals("candList"))
				uri="/WEB-INF/pages/candList.jsp";
			else if(page.equals("vote"))
				uri="/WEB-INF/pages/vote.jsp";
			else if(page.equals("logout"))
				uri="/WEB-INF/pages/logout.jsp";
			else if(page.equals("edit"))
				uri="/WEB-INF/pages/edit.jsp";
			else if(page.equals("delete"))
				uri="/WEB-INF/pages/delete.jsp";
			else if(page.equals("update"))
				uri="/WEB-INF/pages/update.jsp";
			else if(page.equals("announcement"))
				uri="/WEB-INF/pages/announcement.jsp";
			else if(page.equals("announce"))
				uri="/WEB-INF/pages/announce.jsp";
		
			ServletContext ctx = this.getServletContext();
					RequestDispatcher rd = ctx.getRequestDispatcher(uri);
					rd.forward(req, resp);
		}
}