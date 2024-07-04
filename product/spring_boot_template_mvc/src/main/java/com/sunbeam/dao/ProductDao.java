package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Product;

public interface ProductDao extends JpaRepository <Product,Long>{
	
List<Product> findAll();	
}
