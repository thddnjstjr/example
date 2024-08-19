package com.example.demo.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Comment;

@Mapper
public interface CommentRepository {

	public int insert(Comment comment);
	public int updateById(Comment comment);
	public int deleteById(Comment comment);
	public List<Comment>selectByPostId(Integer id);
	
}
