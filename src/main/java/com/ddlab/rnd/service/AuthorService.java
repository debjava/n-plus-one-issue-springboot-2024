package com.ddlab.rnd.service;

import java.util.List;

import com.ddlab.rnd.entity.Author;

public interface AuthorService {
	
	void saveAuthor(Author author);

	void saveAllAuthors(List<Author> authors);
	
	List<Author> findAllAuthors();
	
//	List<Author> getAllAuthors();
}
