package com.opt.springboot.services;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
	
	public String retrieveWelcomeMessage() {
		//Complex Method
		return "Good Morning updated";
	}
}
