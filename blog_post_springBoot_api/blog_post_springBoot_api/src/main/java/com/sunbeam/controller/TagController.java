package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AddTagWithPostDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentReqDto;
import com.sunbeam.dto.TagDto;
import com.sunbeam.service.TagService;

@RestController 
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tserv;
	
	@PostMapping("/add")
	public ResponseEntity<?> addComment(@RequestBody TagDto dto) {
	try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(tserv.addTag(dto));
	} catch (RuntimeException e) {
		// TODO: handle exception
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(e.getMessage()));
	}
	
	}
	@PostMapping("/add/tagpost")
	public ResponseEntity<?> addComment(@RequestBody AddTagWithPostDto dto) {
	try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(tserv.addTagPost(dto));
	} catch (RuntimeException e) {
		// TODO: handle exception
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(e.getMessage()));
	}
	
	}
	@GetMapping("/add/remove/{idT}/{idP}")
	public ResponseEntity<?> addComment(@PathVariable Long idT,@PathVariable Long idP) {
	try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(tserv.removePost(idT, idP));
	} catch (RuntimeException e) {
		// TODO: handle exception
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(e.getMessage()));
	}
	
	}
}
