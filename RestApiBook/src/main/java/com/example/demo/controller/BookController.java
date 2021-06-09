package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController 
{
	//create an object of BookService using @Autowired(private BookService bookService=new BookService();)
	@Autowired
	private BookService bookService;
	
	//get all book handler
	@GetMapping("/books")
	public List<Book> getBook()
	{
		return bookService.getAllBook();
	}
	
	//get book using id handler
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}
	
	//Add new book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
	//delete book handler
	@DeleteMapping("/books/{bid}")
	public void deleteBook(@PathVariable("bid") int id)
	{
		bookService.deleteBook(id);
	}
	
	//update book handler
	@PutMapping("/books/{bid}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bid") int id)
	{
		bookService.updateBook(book,id);
		return book;
	}

}
