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
}
