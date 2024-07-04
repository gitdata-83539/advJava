package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogPostReqDTO;
import com.sunbeam.dto.CommentReqDto;
import com.sunbeam.dto.UpdateTextCommentDto;
import com.sunbeam.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
@Autowired 
private CommentService commentService;
	
@PostMapping
public ResponseEntity<?> addComment(@RequestBody CommentReqDto dto) {
	System.out.println("in add comment "+dto);
	try {
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(commentService.postNewComment(dto));
	} catch (RuntimeException e) {
		System.out.println(e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(e.getMessage()));
				
	}
}

@PutMapping("/update/commenttext")
public ResponseEntity<?> updTextComm(@RequestBody UpdateTextCommentDto dto)
{
	try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(commentService.updateTextComment(dto));
	} catch (RuntimeException e) {
		// TODO: handle exception
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(e.getMessage()));
	}
}
@DeleteMapping("/del/comment/{id}")
public ResponseEntity<?> updTextComm(@PathVariable Long id)
{
	try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(commentService.delByCommenterId(id));
	} catch (RuntimeException e) {
		// TODO: handle exception
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(e.getMessage()));
	}
}
}
	
	

