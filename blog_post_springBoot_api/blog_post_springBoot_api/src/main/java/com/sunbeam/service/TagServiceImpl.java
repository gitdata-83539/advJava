package com.sunbeam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.TagDao;
import com.sunbeam.dto.AddTagWithPostDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.TagDto;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Tag;
@Service
@Transactional
public class TagServiceImpl implements TagService{
@Autowired
private TagDao tdao;
@Autowired
private ModelMapper mapper;
@Autowired
private BlogPostDao pdao;
	@Override
	public ApiResponse addTag(TagDto dto) {
		// TODO Auto-generated method stub
		Tag t= mapper.map(dto, Tag.class);
		tdao.save(t);
		return new ApiResponse("tag added successfully");
	}
	@Override
	public ApiResponse addTagPost(AddTagWithPostDto dto) {
		// TODO Auto-generated method stub
		Tag t= tdao.findByName(dto.getTagname());
		BlogPost bp=pdao.findByTitle(dto.getPostTitle());
		t.getPosts().add(bp);
		tdao.save(t);
		return new ApiResponse("tag added with post successfully");
	}
	@Override
	public ApiResponse removePost(Long idT, Long idP) {
		// TODO Auto-generated method stub
		Tag t=tdao.findById(idT).orElseThrow();
		BlogPost bp=pdao.findById(idP).orElseThrow();
		t.setPosts(null);
		
		return new ApiResponse("removed post from tag");
	}

}
 