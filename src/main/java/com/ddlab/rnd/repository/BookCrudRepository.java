//package com.ddlab.rnd.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.ddlab.rnd.entity.Book;
//
//@Repository
//public interface BookCrudRepository extends CrudRepository<Book, Long> {
//
//	// Following solves N+1 issue, but FetType.LAZY should be defined
//	@Query("select b from Book b join fetch b.author")
//	public List<Book> getAllBooks();
//	
//	@EntityGraph("Book.author")
//	@Query("select b from Book b")
//	public List<Book> getAllBooksUsingNamedEntityGraph();
//	
//	// Only using @EntityGraph
//	@EntityGraph(attributePaths = {"author"})
//	@Query("select b from Book b")
//	public List<Book> getAllBooksOnlyUsingEntityGraph();
//	
//
//}
