package com.example.durgesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CSS_JS_Controller {

	@RequestMapping("/example")
	public String example()
	{
		return "CSS_JS_Example";
	}
}
