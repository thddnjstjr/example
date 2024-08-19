package com.example.demo.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Post {

	private Integer id;
	private String title;
	private String content;
	private String image;
	private String authorId;
	private Timestamp createdAt;
}
