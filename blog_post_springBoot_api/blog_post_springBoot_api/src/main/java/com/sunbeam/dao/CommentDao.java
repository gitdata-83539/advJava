package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Long>
{   @Modifying
	@Query("delete from Comment c where c.commenter.id = :id")
	int delAllCoomentByCommenterId(Long id);
	
}
	
	