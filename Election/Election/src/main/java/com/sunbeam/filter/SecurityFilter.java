package com.sunbeam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.pojos.User;
@WebFilter({"/candlist","/vote","/result"})
public class SecurityFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("SecurityFilter.init() called.");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("SecurityFilter.destroy() called.");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession session=req.getSession();
		User user= (User)session.getAttribute("curuser");
		if(user==null)
		{
			HttpServletResponse resp=(HttpServletResponse) response;
			resp.sendRedirect("index.html");
			
		}
		else
		{
			chain.doFilter(request, response);
			
		}
	}
	
}
