package com.crud.service;

import java.util.List;

import com.crud.entity.Book;

public interface BookServiceI {

	Book createBook(Book book);
		
	List<Book> getAvailableBooks();
}
