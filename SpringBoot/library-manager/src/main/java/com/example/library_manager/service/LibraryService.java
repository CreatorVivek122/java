package com.example.library_manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.library_manager.model.Book;

@Service
public class LibraryService {
	private final List<Book> books = new ArrayList<>();
	
	public List<Book> getAllBooks() {
		return books;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public boolean removeBook(String title) {
		return books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
	}
}
