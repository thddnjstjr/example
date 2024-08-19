package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.Comment;
import com.example.demo.dto.Post;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;

import jakarta.servlet.http.HttpSession;


@Controller
public class BoardController {

	@Autowired
	private HttpSession session;
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/board/detail")
	public String getMethodName(@RequestParam("id") Integer id,Model model) {
		Post post = postService.selectById(id);
		List<Comment> commentList = commentService.selectByPostId(id);
		model.addAttribute("commentList",commentList);
		model.addAttribute("post",post);
		return "board/detail";
	}
	
	@PostMapping("/board/comment")
	public String getMethodName(Comment comment,Model model) {
		commentService.insertComment(comment);
		Post post = postService.selectById(comment.getPostId());
		List<Comment> commentList = commentService.selectByPostId(comment.getPostId());
		model.addAttribute("commentList",commentList);
		model.addAttribute("post",post);
		return "board/detail";
	}
	
	
	
	
}
