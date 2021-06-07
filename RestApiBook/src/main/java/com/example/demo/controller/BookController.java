package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController 
{
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBook()
	{
		return bookService.getAllBook();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}

}
