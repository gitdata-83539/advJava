package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class CommentReqDto {
	
	
		private Long commenterId;
		private Long postId;
		private String commentText;
		private int rating;
			}


