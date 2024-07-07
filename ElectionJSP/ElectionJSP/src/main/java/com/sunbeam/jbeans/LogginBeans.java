package com.sunbeam.jbeans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LogginBeans {
	
	private String email;
	private String password;
	private User user = null;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "LogginBeans [email=" + email + ", password=" + password + ", user=" + user + "]";
	}
	public void authenticate()
	{
		try {
			UserDao userdao= new UserDaoImpl();
			System.out.println(email);
			User u=userdao.findByEmail(this.email);
			System.out.println(u.getPassword());
			if(u!=null && this.password.equals(u.getPassword()))
			{   System.out.println(u.toString());
				this.user=u;
				System.out.println("hello");
			}
			else
			{
				this.user=null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
