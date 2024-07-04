package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentReqDto;
import com.sunbeam.dto.CommentResDto;
import com.sunbeam.dto.UpdateTextCommentDto;


public interface CommentService {
	
	ApiResponse postNewComment(CommentReqDto requestDTO);
	ApiResponse updateTextComment (UpdateTextCommentDto dto);
	int delByCommenterId(Long id);
}
