package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Book;
import com.crud.repository.BookRepository;


@Service
public class BookServiceImpl implements BookServiceI {

	private BookRepository bookRepository;
	
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAvailableBooks() {
		return bookRepository.findAll();
	}
}
