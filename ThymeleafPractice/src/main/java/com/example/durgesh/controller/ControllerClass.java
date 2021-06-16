package com.example.durgesh.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerClass {
	
	//Handling for including fragment
	@GetMapping("/service")
	public String ServiceHandler(Model m)
	{
		return "service";
	}
	
	//Handling for including fragment
		@GetMapping("/service2")
		public String ServiceHandler2(Model m)
		{
			m.addAttribute("title","I like Spring Boot");
			m.addAttribute("subtitle",LocalDateTime.now().toString());
			return "service2";
		}
		
	//For new About
		@GetMapping("/newabout")
		public String newAbout()
		{
			return "aboutnew";
		}

		//For new contact
		@GetMapping("/contact")
		public String contact()
		{
			return "contact";
		}

	
}
