package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class TemplateController {
	
	@GetMapping("/index")
	
	public String index()
	{
		return "index.html";
	}
	@GetMapping("/login")
	
	public String login()
	{
		return "login.html";
	}
	@GetMapping("/profile")
	
	public String profile()
	{
		return "profile.html";
	}
	@GetMapping("/register")
	
	public String register()
	{
		return "register.html";
	}
	@GetMapping ("/password")
	public String password()
	{
		return "password.html";
	}
}
