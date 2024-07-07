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

@WebFilter("/*")
public class LoggingFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LoggingFilter.init() called.");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LoggingFilter.destroy() called.");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req= (HttpServletRequest) request;
		System.out.println("Log BEFORE: " + req.getRequestURI());
		chain.doFilter(request, response);
		System.out.println("Log After: " + req.getRequestURI());
		
		
	}
}
