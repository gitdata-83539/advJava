package com.sunbeam.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ApplicationListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext ctx= sce.getServletContext();
		System.out.println("Election servlet application started");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext ctx= sce.getServletContext();
		System.out.println("Election servlet application stopped");
	}
}
