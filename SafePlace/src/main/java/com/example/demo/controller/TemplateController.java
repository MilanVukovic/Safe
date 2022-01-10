package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;

@Controller 
public class TemplateController {
	
	@RequestMapping("/index")
    public String viewHomePage(Model model) {
    	model.addAttribute("user", new User());
        return "index";
    }
	
	@RequestMapping("/login")
	public String login()
	{
		return "login.html";
	}
	
	@PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        System.out.println("Logging user login success...");
 
        return "index";
    } 
	
	@RequestMapping("/profile")
	public String profile()
	{
		return "profile.html";
	}
	
	@RequestMapping("/register")
	public String register()
	{
		return "register.html";
	}
	
	@RequestMapping("/passwordPage")
	public String password()
	{
		return "passwordPage.html";
	}
	
	@RequestMapping("/editprofile")
	public String editprofile()
	{
		return "editprofile.html";
	}
}
