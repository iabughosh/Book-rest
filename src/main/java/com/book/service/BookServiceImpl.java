package com.book.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.book.model.Book;
import com.book.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository repository;

	@PostConstruct
	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Throwable t) {

		}
	}

	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<String> addBook(Book book) {

		/*
		 * for (int i=0; i < 10000000; i++) {
		 * 
		 * Book book1 = new Book(); book1.setIsbn("TEST ISBN " + i);
		 * book1.setCategoryType(com.book.model.Book.CategoryType.FICTION);
		 * book1.setPrice(23.0); book1.setName("Name" + i);
		 * book1.setDescription("Testing all things " + i); book1.setTotalBuyers(1);
		 * 
		 * repository.save(book1);
		 * 
		 * }
		 */

		book = repository.save(book);

		return new ResponseEntity<>("Book saved", HttpStatus.OK);
	}
}
