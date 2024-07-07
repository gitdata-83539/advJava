package com.sunbeam.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sunbeam.pojos.User;
@WebListener
public class AppSessionListener implements HttpSessionListener{
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("new session started!!!");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session=se.getSession();
		User user= (User)session.getAttribute("curuser");
		System.out.println("http session stopped- "+user.getFirstName());
	}
	
}
