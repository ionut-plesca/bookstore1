package com.ionut.bookstore.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ionut.bookstore.entities.Book;
import com.ionut.bookstore.helpers.Status;
import com.ionut.bookstore.repositories.BookRepository;

@RestController
public class BookController {

	private Logger logger = LoggerFactory.getLogger(BookController.class);

	private BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Status insertBook(@RequestBody Book book) {
		logger.info(book.toString());
		Status status = new Status();
		try {
			bookRepository.save(book);
			status.setMsgCode("0");
			status.setMsgDesc("The book with the isbn " + book.getIsbn() + " was inserted");
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			status.setMsgCode("-1");
			status.setMsgDesc("Error at insert");
			return status;
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public Status modifyBook(@RequestBody Book book) {
		logger.info(book.toString());
		Status status = new Status();
		if (bookRepository.findBookByIsbn(book.getIsbn()).equals(book)) {
			status.setMsgCode("-10");
			status.setMsgDesc("The book exists");
			return status;
		}
		try {
			bookRepository.setBookByIsbn(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(),
					book.getPrice());
			status.setMsgCode("0");
			status.setMsgDesc("The book with the isbn " + book.getIsbn() + " was inserted");
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			status.setMsgCode("-1");
			status.setMsgDesc("Error at insert");
			return status;
		}
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	@ResponseBody
	public List<Book> search(@RequestParam(value="isbn") String isbn) {
		return bookRepository.findBookByIsbn(isbn);
		
	}
}
