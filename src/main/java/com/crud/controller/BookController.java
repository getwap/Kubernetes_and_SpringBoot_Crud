package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Book;
import com.crud.service.BookServiceI;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Autowired
	private BookServiceI bookService;
	
	@PostMapping("/")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return ResponseEntity.ok(bookService.createBook(book));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(bookService.getAvailableBooks());
	}
}
