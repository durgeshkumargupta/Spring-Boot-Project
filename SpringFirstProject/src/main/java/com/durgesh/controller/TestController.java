package com.durgesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
	
	@RequestMapping("/test")
	public String display()
	{
		System.out.println("This is Display");
		return "Hello This is Controller Class";
	}

}
