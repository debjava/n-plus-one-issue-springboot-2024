package com.ddlab.rnd;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.Author;
import com.ddlab.rnd.entity.Book;
import com.ddlab.rnd.repository.AuthorRepository;
//import com.ddlab.rnd.repository.BookCrudRepository;
//import com.ddlab.rnd.repository.BookJPARepository;
import com.ddlab.rnd.service.AuthorService;

@Component
public class AutoRun1 {

	@Autowired
	private AuthorService authorService;

//	@Autowired
//	private BookCrudRepository bookCrudRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
//	@Autowired
//	private BookJPARepository bookJpaRepo;
	
	public void sleep(long time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void saveAuthorAndBook() {
		
		Author author1 = new Author("Charles Dickens");
		Book book1 = new Book("Great Expectation", 2300);
		Book book2 = new Book("Oliver Twist", 4700);
		author1.getBooks().add(book1);
		author1.getBooks().add(book2);
		authorRepo.save(author1);
		
		Author author2 = new Author("William Shakespeare");
		Book book3 = new Book("Hamlet", 9000);
		Book book4 = new Book("Romeo and Juliet", 8000);
		author2.getBooks().add(book3);
		author2.getBooks().add(book4);
		authorRepo.save(author2);

	}
	
	public void getAllAuthorDetails() {
		Iterable<Author> iterable = authorRepo.findAll();
		List<Author> authorList = StreamSupport
				.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
		
		System.out.println("Author List Size: "+authorList.size());
		sleep(5);
		System.out.println("------------- AFTER 5 SECONDS ---------------");
		authorList.forEach( author -> {
			System.out.println("Author: "+ author.getName());
			Set<Book> books = author.getBooks();
			books.forEach(book -> System.out.println("Book Details: "+book));
		});
	}
	
//	public void getAllAuthorDetailsUsingEntityGraph() {
//		List<Author> authorList = authorRepo.findAllAuthors();
//		System.out.println("Author List Size: "+authorList.size());
//		sleep(5);
//		System.out.println("------------- AFTER 5 SECONDS ---------------");
//		authorList.forEach( author -> {
//			System.out.println("Author: "+ author.getName());
//			Set<Book> books = author.getBooks();
//			books.forEach(book -> System.out.println("Book Details: "+book));
//		});
//	}

	public void getAllDetails() {
		// Below creates N+1 issue
//		authorService.findAllAuthors().forEach( author -> System.out.println("Author: "+author));

		// Below creates only 1 query to fetch all the details.
//		authorService.getAllAuthors().forEach( author -> System.out.println("Author: "+author));

		// With @OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade =
		// CascadeType.ALL)
//		private Set<Book> books = new HashSet<>();
		authorService.findAllAuthors().forEach(author -> System.out.println("Author: " + author));

//		List<Author> authList = authorService.getAllAuthors();
//		authList.forEach( author -> {
//			System.out.println(author.getName());
//			author.getBooks().forEach( book-> {
//				System.out.println("Book: "+book);
//			});
//		});
	}

	

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("Application running ...");

//		saveAuthorAndBook();
		getAllAuthorDetails();
//		getAllAuthorDetailsUsingEntityGraph();
//		getAllBooksDetails();

		System.out.println("DB Operations Completed ...");
	}
}
