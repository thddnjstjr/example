package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Comment;
import com.example.demo.repository.interfaces.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Transactional
	public void insertComment(Comment comment) {
		commentRepository.insert(comment);
	};
	
	public List<Comment> selectByPostId(Integer id) {
		List<Comment> comment = new ArrayList<>();
		comment = commentRepository.selectByPostId(id);
		return comment;
	}
}
