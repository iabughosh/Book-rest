package com.book.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.book.model.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public ResponseEntity<String> addBook(Book book);
}
