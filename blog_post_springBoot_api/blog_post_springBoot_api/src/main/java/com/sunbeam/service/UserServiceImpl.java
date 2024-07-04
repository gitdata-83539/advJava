package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.AuthenticationException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AddressDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.RegisterDto;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// depcy
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRespDTO authenticateUser(AuthRequest dto) {
		// 1.invoke dao 's method
		User user = userDao.findByEmailAndPassword(
				dto.getEmail(), dto.getPwd())
				.orElseThrow(() -> 
				new AuthenticationException("Invalid Email or Password !!!!!!"));
		//valid login -user : persistent -> entity -> dto
		return mapper.map(user, UserRespDTO.class);
	}

	@Override
	public ApiResponse registerUser(RegisterDto dto) {
		// TODO Auto-generated method stub
		User user=mapper.map(dto,User.class);
		User user1=userDao.save(user);
		if(user1!=null)
		{
			return new ApiResponse("registration successfull");
		}
		return new ApiResponse("registration failed");
	}

	@Override
	public ApiResponse addAddress(AddressDto dto) {
		// TODO Auto-generated method stub
		User u= userDao.findById(dto.getId()).orElseThrow();
		Address ad=mapper.map(dto, Address.class);
		u.setUserAddress(ad);
		userDao.save(u);
		return new ApiResponse("address added successfully");
	}

	@Override
	public List<User> searchByCity(String city) {
		// TODO Auto-generated method stub
		List<User> u= userDao.findByUserAddressCity(city);
		return u;
	}

}

