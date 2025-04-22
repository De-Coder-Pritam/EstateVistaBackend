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
	
	private String email;
	
	private String name;
	
	private String phoneNumber;
	private String role;
	
	
}
