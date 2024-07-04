package com.sunbeam.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentReqDto;
import com.sunbeam.dto.CommentResDto;
import com.sunbeam.dto.UpdateTextCommentDto;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.User;
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	@Autowired
	private BlogPostDao blogPostDao;
	@Autowired
	private ModelMapper mapper;
    @Autowired
	private UserDao userDao;
    @Autowired 
    private CommentDao commentDao;
	@Override
	public ApiResponse postNewComment(CommentReqDto requestDTO) {
		// TODO Auto-generated method stub
		User commenter = userDao.findById(requestDTO.getCommenterId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid COMMENTER id!!!"));
		
		BlogPost post= blogPostDao.findById(requestDTO.getPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid POST id!!!"));
		
		Comment comment=mapper.map(requestDTO, Comment.class);
		comment.setCommenter(commenter);
		comment.setPost(post);
		System.out.println("hello");
		Comment persistentComment = commentDao.save(comment);
		return new ApiResponse("New comment added");
	}
	@Override
	public ApiResponse updateTextComment(UpdateTextCommentDto dto) {
		// TODO Auto-generated method stub
		Comment c= commentDao.findById(dto.getId()).orElseThrow();
		c.setCommentText(dto.getText());
		return new ApiResponse(" comment updated");
	}
	@Override
	public int delByCommenterId(Long id) {
		// TODO Auto-generated method stub
		int i= commentDao.delAllCoomentByCommenterId(id);
		
		return i;
	}

}
