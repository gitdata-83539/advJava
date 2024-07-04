package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.AddressDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.RegisterDto;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;

public interface UserService {
//user signin
	UserRespDTO authenticateUser(AuthRequest dto);
	ApiResponse registerUser(RegisterDto dto);
	ApiResponse addAddress(AddressDto dto);
	List<User> searchByCity(String city);
}
