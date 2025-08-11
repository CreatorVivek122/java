package com.example.library_manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.library_manager.model.Book;
import com.example.library_manager.repository.BookRepository;

@Service
public class LibraryService {
//	private final List<Book> books = new ArrayList<>();
	private final BookRepository  repository;
	
	public LibraryService(BookRepository repository) {
		this.repository = repository;
	}
	
	public List<Book> getAllBooks() {
		return repository.findAll();
	}
	
	public void addBook(Book book) {
		repository.save(book);
	}
	
	public boolean removeBook(String title) {
		try {
			repository.deleteByTitle(title);
			return true;
		} catch (Exception e){
			return false;
		}
	}
}
