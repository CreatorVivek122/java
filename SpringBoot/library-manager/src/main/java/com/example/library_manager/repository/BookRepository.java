package com.example.library_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_manager.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	void deleteByTitle(String title);
}
