package com.ionut.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "books")
public class Book {
	
	@Column(name="isbn", unique=true)
	@NotNull
	private String isbn;
	
	@Column(name="title")
	private String title;
	
	@Column (name="author")
	private String author;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="price")
	private Double price;
	
	@Id
	@GeneratedValue
//	@JsonIgnore
	private String id;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	private String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}
	
	public Book() {
		
	}

	public Book(String isbn, String title, String author, String publisher, Double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + "]";
	}
	
	
	

}
