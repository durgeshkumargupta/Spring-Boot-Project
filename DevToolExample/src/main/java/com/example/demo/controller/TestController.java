package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


	@RequestMapping("/sum")
	@ResponseBody
	public String Display()
	{
		int a=10;
		int b=20;
		int c=40;
		return "Sum of all values:"+(a+b+c);
	}
}
