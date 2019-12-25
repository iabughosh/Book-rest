package com.book.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.service.BookService;

@RestController
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	private BookService bs;
	
	@GetMapping( path = "/get",produces = "application/json")
	public List<Book> getBooks(){
		return bs.getAllBooks();
	}
	
	@PostMapping(path = "/add",produces = "application/json")
	public ResponseEntity<String> addBook(@RequestBody Book book){		
		return bs.addBook(book);			
	}
}
