package com.sunbeam.service;

import com.sunbeam.dto.AddTagWithPostDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.TagDto;

public interface TagService {
	
	ApiResponse addTag(TagDto dto);
	ApiResponse addTagPost(AddTagWithPostDto dto);
	ApiResponse removePost(Long idT,Long idP);
}
