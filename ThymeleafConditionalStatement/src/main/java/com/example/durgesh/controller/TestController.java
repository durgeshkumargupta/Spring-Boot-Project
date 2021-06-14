package com.example.durgesh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public String ConditionStatementCheckMethod(Model model)
	{
		model.addAttribute("isActive", true);
		
		model.addAttribute("gender", "F");
		
		List<Integer> list=List.of(222,33,34,56,34,44,65);
		
		model.addAttribute("mylist",list);
		return "ConditionStatementCheck";
	}
}
