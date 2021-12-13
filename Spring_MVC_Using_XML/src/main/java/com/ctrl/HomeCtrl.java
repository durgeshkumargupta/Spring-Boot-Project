package com.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import com.entities.Todo;

@Controller
public class HomeCtrl 
{
	@Autowired
	ServletContext context;
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		String str="home";
		model.addAttribute("page", str);
		
		List<Todo> list=(List<Todo>)context.getAttribute("list");
		model.addAttribute("todos",list);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m)
	{
		Todo t=new Todo();
		m.addAttribute("page", "add");
		m.addAttribute("todo",t);
		return "home";
	}
	
	@RequestMapping(value="/saveTodo" ,method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t,Model m)
	{
		System.out.println(t);
		List<Todo> list=(List<Todo>)context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg","Successfulyy added...");
		t.setTodoDate(new Date());
		return "home";
	}
	
	

}
