package com.example.library_manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.library_manager.model.Book;
import com.example.library_manager.service.LibraryService;

@RestController
@RequestMapping("/api/books")
public class LibraryController {
	private final LibraryService service;
	
	public LibraryController(LibraryService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Book> getBooks(){
		return service.getAllBooks();
	}
	
	@PostMapping
	public String addBook(@RequestBody Book book) {
		service.addBook(book);
		return "Book added Successfully.";
	}
	
	@DeleteMapping("/{title}")
	public String removeBook(@PathVariable String title) {
		boolean removed = service.removeBook(title);
		return removed ? "Book removed Successfully. " : "Book not found.";
	}
}
