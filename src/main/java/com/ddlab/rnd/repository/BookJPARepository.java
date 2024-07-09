//package com.ddlab.rnd.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.ddlab.rnd.entity.Book;
//
//@Repository
//public interface BookJPARepository extends JpaRepository<Book, Long> {
//
////	@EntityGraph("Book.author")
////	@EntityGraph(value = "Book.author", type = EntityGraphType.LOAD)
//	@EntityGraph("Book.author")
//	@Query("select b from Book b")
//	public List<Book> getAllBooksUsingNamedEntityGraph();
//}
