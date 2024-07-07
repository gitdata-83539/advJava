package com.sunbeam.jbeans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegisterBeans {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private String role;
	private int count;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "RegisterBeans [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", dob=" + dob + ", role=" + role + ", count=" + count + "]";
	}
	public void insertUser()
	{
		try {
			UserDao udao=new UserDaoImpl();
			
			Date d=Date.valueOf(dob);
			User u=new User(firstName,lastName,email,password,d,role);
			System.out.println(u.toString());
			 count=udao.save(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
