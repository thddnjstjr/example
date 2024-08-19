package com.example.demo.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Post;
import com.example.demo.repository.interfaces.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void createPost(Post post) {
		int result = 0;
		result = postRepository.insert(post);
		
	}
	
	public void deletePost(Integer id) {
		int result = 0;
		result = postRepository.deleteById(id);
	}
	
	public List<Post> selectPostList(Integer limit,Integer offset) {
		List<Post> postList = new ArrayList<>();
		postList = postRepository.selectList(limit, offset);
		return postList;
	}
	
	public List<Post> selectPostAll() {
		List<Post> postList = new ArrayList<>();
		postList = postRepository.selectAll();
		return postList;
	}
	
	public Post selectById(Integer id) {
		Post post = postRepository.selectById(id);
		return post;
	}
}
