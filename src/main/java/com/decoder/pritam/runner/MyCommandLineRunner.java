package com.decoder.pritam.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.decoder.pritam.model.User;
import com.decoder.pritam.service.UserService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private UserService uservice;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Application Started");
//		User u1 = new User();
//		u1.setEmail("pritam@gmail.com");
//		u1.setName("Pritam");
//		u1.setPassword("p@123");
//		u1.setPhoneNumber("7033617904");
//		u1.setRole("ADMIN");
//		
//		uservice.createUser(u1);
//		
//		User u2 = new User();
//		u2.setEmail("aditya@gmail.com");
//		u2.setName("Aditya");
//		u2.setPassword("a@123");
//		u2.setPhoneNumber("9142353744");
//		u2.setRole("ADMIN");
//		
//		uservice.createUser(u2);

	}

}
