package com.opt.springboot.services;

import org.springframework.stereotype.Component;

import com.opt.springboot.entity.User;

@Component
public class WelcomeService {
	
	public String retrieveWelcomeMessage() {
		//Complex Method
		return "Good Morning updated";
	}

	public String addUserToDb(User user) {
		System.out.println(user.toString());
		return null;
	}

}
