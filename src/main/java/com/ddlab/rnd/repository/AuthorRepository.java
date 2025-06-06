package com.ddlab.rnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	
	// Following solves N+1 issue
//	@Query("select a from Author a join fetch a.books")
//	public List<Author> getAllAuthors();
	
//	@Query("select a from Author a join fetch a.books")
//	public Iterable<Author> findAll();
//	
//	@EntityGraph(attributePaths = {"books"})
//	@Query("select a from Author a")
//	public List<Author> findAllAuthors();

}
