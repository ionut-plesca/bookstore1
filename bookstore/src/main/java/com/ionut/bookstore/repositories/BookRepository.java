package com.ionut.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ionut.bookstore.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findBookByIsbn(String isbn);

	List<Book> findBookByTitle(String title);

	@Modifying
	@Query("update Book b set b.title=?2, b.author=?3, b.publisher=?4, b.price=?5 where b.isbn=?1")
	@Transactional
	void setBookByIsbn(String isbn,  String title,
			 String author,  String publisher,
			 Double price);

}
