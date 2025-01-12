package com.decoder.pritam.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
	private Long userId;
	private String email;
	
	private String name;
	private String password;
	private String phoneNumber;
	private String role;
	
	private Date createdAt;
}
