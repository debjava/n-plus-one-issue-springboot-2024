package com.ddlab.rnd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.Author;
import com.ddlab.rnd.repository.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Transactional
	@Override
	public void saveAuthor(Author author) {
		authorRepo.save(author);
	}

	@Transactional
	@Override
	public List<Author> findAllAuthors() {
		List<Author> authorList = new ArrayList<>();
		authorRepo.findAll().forEach( val-> authorList.add(val));
		return authorList;
	}
	
	@Transactional
	@Override
	public void saveAllAuthors(List<Author> authors) {
		authorRepo.saveAll(authors);
		
	}
	
//	@Transactional
//	@Override
//	public List<Author> getAllAuthors() {
//		return authorRepo.getAllAuthors();
//	}
}
