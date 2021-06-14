package com.example.durgesh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public String ItertaionOpertion(Model m)
	{
		List<String> names=List.of("Durgesh","Prince","Adity","Saurav","Lucky");
		m.addAttribute("names", names);
		return "iteration";
	}
}
