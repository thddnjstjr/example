package com.example.demo.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Comment {

	private Integer id;
	private Integer postId;
	private String content;
	private String authorId;
	private Timestamp createdAt;
	
}
