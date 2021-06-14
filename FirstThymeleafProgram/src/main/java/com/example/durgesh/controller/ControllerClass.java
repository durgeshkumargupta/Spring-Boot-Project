package com.example.durgesh.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerClass {

	@RequestMapping(value="/about" ,method = RequestMethod.GET)
	public String about(Model model)
	{
		model.addAttribute("name","Durgesh");
		model.addAttribute("name2","Prince");
		model.addAttribute("currentDate",new Date().toLocaleString());
		return "about";//about.html
	}
}
