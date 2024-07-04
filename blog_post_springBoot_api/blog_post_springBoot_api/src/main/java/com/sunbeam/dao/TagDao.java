package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Tag;
import java.lang.String;
import java.util.List;

public interface TagDao extends JpaRepository<Tag, Long>{
	Tag findByName(String name);
}
