package com.rituj.swaggerImpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rituj.swaggerImpl.domain.User;
import com.rituj.swaggerImpl.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addUser(User user) {
		 userService.addNewUser(user);
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getUser(String userID)
	{
		return "Hi";
	}
	
	@RequestMapping(value="/",method = RequestMethod.PUT)
	public String updateUser(String userID)
	{
		return "Hi";
	}
}
