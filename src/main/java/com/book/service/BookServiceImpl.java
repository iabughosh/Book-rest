package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.book.model.Book;
import com.book.repository.BookRepository;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository repository;
	
	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<String> addBook(Book book){
		repository.save(book);		
		return new ResponseEntity<>("Book saved", HttpStatus.OK);
	}

}
