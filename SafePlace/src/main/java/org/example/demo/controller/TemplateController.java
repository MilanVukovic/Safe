package org.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.example.demo.model.User;
import org.example.demo.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class TemplateController {
	
	@Autowired
	UserServices service;
	
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
	
	
	
	@RequestMapping("/profile")
	public String profile()
	{
		return "profile.html";
	}
	
	@RequestMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("user", new User());
		return "register.html";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user, HttpServletRequest request) {
		service.register(user);
	     
	    return "register_success";
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
