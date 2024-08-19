package com.example.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Token {

	private String tokenType;
	private String accessToken;
	private Integer expiresIn;
	private String refreshToken;
	private Integer refreshTokenExpiresIn;
	
}
