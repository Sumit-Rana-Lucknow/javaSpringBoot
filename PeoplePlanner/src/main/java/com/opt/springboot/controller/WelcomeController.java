package com.opt.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opt.springboot.entity.User;
import com.opt.springboot.services.WelcomeService;


@RestController
public class WelcomeController {
	
	@Autowired
	private WelcomeService service;

	@RequestMapping("/welcome")
	public String welcome(){
		return service.retrieveWelcomeMessage();
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public User addUser(@RequestBody User user){
		return service.addOrUpdateUserToDb(user);
	}
	
	@RequestMapping(value = "/findUser/{userId}", method = RequestMethod.GET)
	public User addUser(@PathVariable() Long userId){
		return service.findUser(userId);
	}
}
