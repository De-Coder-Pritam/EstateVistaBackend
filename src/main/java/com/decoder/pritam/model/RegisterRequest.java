package com.decoder.pritam.model;


import lombok.Data;

@Data
public class RegisterRequest {
	private String username;
	private String email;
    private String password;
    private String role; // Optional, default can be "ROLE_USER"
    private String phoneNumber;
}


