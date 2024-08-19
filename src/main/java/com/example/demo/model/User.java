package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	
	private String userName;
	private String nickName;
	private String userImage;
	
	public String setUpUserImage() {
		System.out.println(userImage);
		return this.userImage;
	}
}
