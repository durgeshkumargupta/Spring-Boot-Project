package com.durgesh.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.durgesh.entities.Book;
import com.durgesh.repository.BookRepository;


@Component
public class BookService 
{
	@Autowired
	private BookRepository bookRespository;
	
	//get all book
	public List<Book> getAllBook()
	{
		List<Book> bookList=(List<Book>)bookRespository.findAll();
		return bookList;
	}
	
	
	//get one book using id
	public Book getBookById(int id)
	{
		Book book_name=null;
		try {
			book_name=bookRespository.findById(id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return book_name;
	}
	
	//Add new Book
	public Book addBook(Book b)
	{
		Book book=bookRespository.save(b);
		return book;
	}
	
	
	//delete one book using id
	public void deleteBook(int bid)
	{
		bookRespository.deleteById(bid);
	}
	
	//update book data using id
	public void updateBook(Book book,int id)
	{
		book.setId(id);
		bookRespository.save(book);
	}
}