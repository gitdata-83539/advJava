package com.sunbeam.controller;

import java.lang.Thread.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AddressDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.RegisterDto;
import com.sunbeam.service.UserService;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired //byType
	private UserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}

	/*
	 * Desc - User signin URL - http://host:port/users/signin Method - POST payload
	 * - dto (email n pwd) Successful Resp - SC 200, user details - all (dto) Error
	 * resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
	 * 
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> signInUser(@RequestBody AuthRequest request) {
		System.out.println("in signin " + request);
		try {
			return ResponseEntity.ok(userService.authenticateUser(request));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody RegisterDto dto)
	{
		
		System.out.println("inside signup");
		try {
			return ResponseEntity.ok(userService.registerUser(dto));
		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping("/address")
	public ResponseEntity<?> addAddresss(@RequestBody AddressDto dto)
	{
		try {
			return ResponseEntity.status( HttpStatus.CREATED).body(userService.addAddress(dto));

		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("address not added successfully!!"); 
		}
	
	}
	@GetMapping("/city{city}")
	public ResponseEntity<?> addAddresss(@PathVariable String city)
	{
		try {
			return ResponseEntity.status( HttpStatus.CREATED).body(userService.searchByCity(city));

		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("city not found!!!!!"); 
		}
	
	}
	
}



