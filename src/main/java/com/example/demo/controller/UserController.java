package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Code;
import com.example.demo.dto.Kakao;
import com.example.demo.dto.Post;
import com.example.demo.dto.Token;
import com.example.demo.model.User;
import com.example.demo.service.PostService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private final HttpSession session;
	@Autowired
	private final PostService postService;
	
	@GetMapping("/user/sign-in")
	public String signInPage() {
		return "user/signIn";
	}
	
	@GetMapping("/user/sign-up")
	public String signUpPage() {
		return "user/signUp";
	}
	
	@GetMapping("/user/kakao")
	public String getMethodName(Code code,Model model) {
		String codeNum = code.getCode();
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "8bb6c018765bb2c344effb3d2a16636a");
		params.add("redirect_uri", "http://localhost:8080/user/kakao");
		params.add("code", codeNum);
		
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params,headers);
		
		ResponseEntity<Token> response = restTemplate.exchange("https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,requestEntity,Token.class);
		
		Token token = response.getBody();
		RestTemplate restTemplate2 = new RestTemplate();
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + token.getAccessToken());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		HttpEntity<MultiValueMap<String, String>> requestEntity2 = new HttpEntity<>(null,headers2);
		
		ResponseEntity<Kakao> response2 = restTemplate2.exchange("https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST,requestEntity2,Kakao.class);
		Kakao kakao = response2.getBody();
		User kakaoUser = User.builder().userName(kakao.getKakao_account().getProfile().getNickname())
				.userImage(kakao.getKakao_account().getProfile().getProfile_image_url()).build();
		
		List<Post> postList = postService.selectPostList(5,0);
		List<Post> Allpost = postService.selectPostAll();
		int size = 0;
		if(Allpost.size() % 5 == 0) {
			size = Allpost.size() / 5;
		} else {
			size = (Allpost.size() / 5) + 1;
		}
		model.addAttribute("size",size);
		model.addAttribute("postList",postList);
		session.setAttribute("principal", kakaoUser);
		
		return "main";
	}
	
}
