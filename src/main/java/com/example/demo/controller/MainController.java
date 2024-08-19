package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Post;
import com.example.demo.model.User;
import com.example.demo.service.PostService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class MainController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private PostService postService;
	
	@GetMapping({"/main","/index"})
	public String mainPage(Model model) {
		List<Post> postList = postService.selectPostList(5, 0);
		List<Post> Allpost = postService.selectPostAll();
		int size = 0;
		if(Allpost.size() % 5 == 0) {
			size = Allpost.size() / 5;
		} else {
			size = (Allpost.size() / 5) + 1;
		}
		model.addAttribute("size",size);
		model.addAttribute("postList",postList);
		return "main";
	}
	
	@GetMapping("/main/write")
	public String writePage() {
		return "board/write";
	}
	
	@PostMapping("/main/submitPost")
	public String postMethodName(Post post,Model model) {
		System.out.println("글쓰기 정보 들어옴");
		User principal = (User)session.getAttribute("principal");
		post.setAuthorId(principal.getUserName());
		postService.createPost(post);
		List<Post> postList = postService.selectPostList(5, 0);
		List<Post> Allpost = postService.selectPostAll();
		int size = 0;
		if(Allpost.size() % 5 == 0) {
			size = Allpost.size() / 5;
		} else {
			size = (Allpost.size() / 5) + 1;
		}
		model.addAttribute("size",size);
		model.addAttribute("postList",postList);
		
		return "main";
	}
	
	@GetMapping("/main/select")
	public String selectPage(@RequestParam("number") String param,Model model) {
		System.out.println("페이지 번호 : " + param);
		int offset = (Integer.parseInt(param) - 1) * 5;
		List<Post> postList = postService.selectPostList(5, offset);
		List<Post> Allpost = postService.selectPostAll();
		int size = 0;
		if(Allpost.size() % 5 == 0) {
			size = Allpost.size() / 5;
		} else {
			size = (Allpost.size() / 5) + 1;
		}
		model.addAttribute("size",size);
		model.addAttribute("postList",postList);
		return "main";
	}
	
	@GetMapping("/main/update")
	public String updatePage(@RequestParam("id") Integer id,Model model) {
		Post post = postService.selectById(id);
		model.addAttribute("post",post);
		return "board/update";
	}
	
	@GetMapping("/main/delete")
	public String getMethodName(@RequestParam("id") Integer id,Model model) {
		postService.deletePost(id);
		List<Post> postList = postService.selectPostList(5, 0);
		List<Post> Allpost = postService.selectPostAll();
		int size = 0;
		if(Allpost.size() % 5 == 0) {
			size = Allpost.size() / 5;
		} else {
			size = (Allpost.size() / 5) + 1;
		}
		model.addAttribute("size",size);
		model.addAttribute("postList",postList);
		return "main";
	}
	
}
