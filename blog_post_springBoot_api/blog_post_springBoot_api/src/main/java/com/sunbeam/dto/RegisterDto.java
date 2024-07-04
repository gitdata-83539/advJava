package com.sunbeam.dto;

import java.time.LocalDate;

import com.sunbeam.entities.Role;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegisterDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private Role role;
	
}
