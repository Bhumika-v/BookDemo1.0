package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.services.UserService;

@Controller
public class ApplicationController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping("/welcome")
	public String Welcome()
	{
		return "welcomehome";	
	}
	
	@RequestMapping("/register")
	public String registration() {
		
		return "registerpage";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult) {
		userService.saveMyUser(user);
		
		return "successpage";
	}
}
