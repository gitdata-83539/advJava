package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.User;

public interface UserDao extends JpaRepository<User,Long>{
//add derived finder method for user signin 
	Optional<User> findByEmailAndPassword(String email,String pass);
	List<User> findByUserAddressCity(String City);
	
}
