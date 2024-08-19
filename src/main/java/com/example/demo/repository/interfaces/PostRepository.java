package com.example.demo.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Post;

@Mapper
public interface PostRepository {

	public int insert(Post post);
	public int updateById(Post post);
	public int deleteById(Integer id);
	public List<Post> selectList(@Param("limit")Integer limit , @Param("offset")Integer offset);
	public List<Post> selectAll();
	public Post selectById(Integer id);
	
}
