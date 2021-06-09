package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Book;

@Component
public class BookService 
{
	private static List<Book> book=new ArrayList<>();
	
	static
	{
		book.add(new Book(111,"Java","ABC"));
		book.add(new Book(222,"Python","XYZ"));
		book.add(new Book(333,"C++","PQR"));
		book.add(new Book(444,"C","WXY"));
		book.add(new Book(555,"JavaScript","MNB"));
	
	}
	
	//get all book
	public List<Book> getAllBook()
	{
		return book;
	}
	
	//get one book using id
	public Book getBookById(int id)
	{
		Book book_name=book.stream().filter(e->e.getId()==id).findFirst().get();
		return book_name;
	}
	
	//Add new Book
	public Book addBook(Book b)
	{
		book.add(b);
		return b;
	}
	
	
	//delete one book using id
	public void deleteBook(int bid)
	{
		book=book.stream().filter(b->b.getId()!=bid).collect(Collectors.toList());
	}
	
	//update book data using id
	public void updateBook(Book book,int id)
	{
		this.book.stream().map(b->
		{
			if (b.getId()==id)
			{	
				b.setTiltle(book.getTiltle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}

