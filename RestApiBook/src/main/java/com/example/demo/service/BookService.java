package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Book> getAllBook()
	{
		return book;
	}
	public Book getBookById(int id)
	{
		Book book_name=book.stream().filter(e->e.getId()==id).findFirst().get();
		return book_name;
	}

}
