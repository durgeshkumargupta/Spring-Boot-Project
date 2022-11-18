package com.durgesh.repository;

import org.springframework.data.repository.CrudRepository;

import com.durgesh.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {

	public Book findById(int id);
}
