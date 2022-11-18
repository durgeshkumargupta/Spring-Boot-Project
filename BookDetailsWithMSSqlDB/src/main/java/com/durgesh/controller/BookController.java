package com.durgesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.entities.Book;
import com.durgesh.service.BookService;


@RestController
public class BookController 
{
	//create an object of BookService using @Autowired(private BookService bookService=new BookService();)
	@Autowired
	private BookService bookService;
	
	//get all book handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBook()
	{
		List<Book> list= bookService.getAllBook();
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	}
	
	//get book using id handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
	{
		Book b= bookService.getBookById(id);
		if(b==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else {
			return ResponseEntity.of(Optional.of(b));
		}
		
	}
	
	//Add new book handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		try {
			Book b=bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//delete book handler
	@DeleteMapping("/books/{bid}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bid") int id)
	{
		try {
			bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//update book handler
	@PutMapping("/books/{bid}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bid") int id)
	{
		try {
			bookService.updateBook(book,id);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
			
	}

}