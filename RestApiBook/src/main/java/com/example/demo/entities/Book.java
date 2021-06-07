package com.example.demo.entities;

import java.io.Serializable;


public class Book implements  Serializable
{
	private static final long serialVersionUID = 7249073931356510573L;
	private Integer id;
	private String tiltle;
	private String author;
	
	public Book() {
	}
	
	public Book(Integer id, String tiltle, String author) {
		super();
		this.id = id;
		this.tiltle = tiltle;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTiltle() {
		return tiltle;
	}
	public void setTiltle(String tiltle) {
		this.tiltle = tiltle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", tiltle=" + tiltle + ", author=" + author + "]";
	}
	
	

}
