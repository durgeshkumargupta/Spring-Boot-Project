package com.durgesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerClass {
	
	@RequestMapping("/test")
	public String call_Jsp_Page()
	{
		System.out.println("Hello This is java");
		return "home";
	}

}
