package com.example.durgesh.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Book")
public class Book implements  Serializable
{
	private static final long serialVersionUID = 4405338650874279515L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Book_id")
	private Integer id;
	
	@Column(name="Book_title")
	private String title;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
	public Book() {
	}
	
	public Book(Integer id, String title, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTiltle() {
		return title;
	}
	public void setTiltle(String tiltle) {
		this.title = tiltle;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", tiltle=" + title + ", author=" + author + "]";
	}
	
	

}
