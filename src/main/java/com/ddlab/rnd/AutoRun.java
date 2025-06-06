//package com.ddlab.rnd;
//
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import com.ddlab.rnd.entity.Author;
//import com.ddlab.rnd.entity.Book;
//import com.ddlab.rnd.repository.AuthorRepository;
////import com.ddlab.rnd.repository.BookCrudRepository;
////import com.ddlab.rnd.repository.BookJPARepository;
//import com.ddlab.rnd.service.AuthorService;
//
//@Component
//public class AutoRun {
//
//	@Autowired
//	private AuthorService authorService;
//
////	@Autowired
////	private BookCrudRepository bookCrudRepo;
//	
//	@Autowired
//	private AuthorRepository authorRepo;
//	
////	@Autowired
////	private BookJPARepository bookJpaRepo;
//	
//	public void sleep(long time) {
//		try {
//			TimeUnit.SECONDS.sleep(time);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void saveAuthorAndBook() {
//		
//		Author author1 = new Author("Charles Dickens");
//		Book book1 = new Book("Great Expectation", 2300);
//		Book book2 = new Book("Oliver Twist", 4700);
//		author1.getBooks().add(book1);
//		author1.getBooks().add(book2);
//		
////		book1.setAuthor(author1);
////		book2.setAuthor(author1);
//		authorService.saveAuthor(author1);
//
//		
//		Author author2 = new Author("William Shakespeare");
//		Book book3 = new Book("Hamlet", 9000);
//		Book book4 = new Book("Romeo and Juliet", 8000);
//		author2.getBooks().add(book3);
//		author2.getBooks().add(book4);
////		book3.setAuthor(author2);
////		book4.setAuthor(author2);
//		authorService.saveAuthor(author2);
//
////		Book book5 = new Book("Paradise Lost", 3000);
////		Book book6 = new Book("Paradise Regained", 5000);
////		Author author3 = new Author("John Milton");
////		book5.setAuthor(author3);
////		book6.setAuthor(author3);
////		author3.getBooks().add(book5);
////		author3.getBooks().add(book6);
////		authorService.saveAuthor(author3);
////		
////		Book book7 = new Book("Kanthapura", 3000);
////		Book book8 = new Book("The Cat and Shakespeare", 5000);
////		Author author4 = new Author("Raja Rao");
////		book7.setAuthor(author4);
////		book8.setAuthor(author4);
////		author4.getBooks().add(book7);
////		author4.getBooks().add(book8);
////		authorService.saveAuthor(author4);
//
////		List<Author> authors = List.of(author1, author2);
////		authorService.saveAllAuthors(authors);
//
//	}
//	
//	public void getAllAuthorDetails() {
//		List<Author> authorList = authorService.findAllAuthors();
//		System.out.println("Author List Size: "+authorList.size());
//		sleep(5);
//		System.out.println("------------- AFTER 5 SECONDS ---------------");
//		authorList.forEach( author -> {
//			System.out.println("Author: "+ author.getName());
//			Set<Book> books = author.getBooks();
//			books.forEach(book -> System.out.println("Book Details: "+book));
//		});
//	}
//
//	public void getAllDetails() {
//		// Below creates N+1 issue
////		authorService.findAllAuthors().forEach( author -> System.out.println("Author: "+author));
//
//		// Below creates only 1 query to fetch all the details.
////		authorService.getAllAuthors().forEach( author -> System.out.println("Author: "+author));
//
//		// With @OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade =
//		// CascadeType.ALL)
////		private Set<Book> books = new HashSet<>();
//		authorService.findAllAuthors().forEach(author -> System.out.println("Author: " + author));
//
////		List<Author> authList = authorService.getAllAuthors();
////		authList.forEach( author -> {
////			System.out.println(author.getName());
////			author.getBooks().forEach( book-> {
////				System.out.println("Book: "+book);
////			});
////		});
//	}
//
//	public void getAllBooksDetails() {
//		List<Author> authorList = StreamSupport
//				.stream(authorRepo.findAll().spliterator(), false)
//				.collect(Collectors.toList());
//		
////		List<Author> authorList = authorRepo.findAll();
//		
////		bookCrudRepo.findAll().forEach( book-> System.out.println("Book: "+book));
//		// Total 3 Authors, 4 queries are fired, so 3+1, N+1 issue
////		bookCrudRepo.findAll().forEach( book-> {
////			System.out.println("Book: "+book);
////			Author author = book.getAuthor();
////			System.out.println("Author: "+author);
////		});
////		bookCrudRepo.getAllBooks().forEach( book-> System.out.println("Book: "+book));
//		
//		//Using Join Fetch
////		bookCrudRepo.getAllBooks().forEach( book-> {
////			System.out.println("Book: "+book);
////			Author author = book.getAuthor();
////			System.out.println("Author: "+author);
////		});
//
//		// @ManyToOne(fetch = FetchType.EAGER)
////		bookCrudRepo.findAll().forEach(book -> {
////			System.out.println("Book: " + book);
////			Author author = book.getAuthor();
////			System.out.println("Author: " + author);
////		});
//		
//		//Using NamedEntityGraph
////		bookCrudRepo.getAllBooksUsingNamedEntityGraph().forEach(book -> {
////			System.out.println("Book: " + book);
////			Author author = book.getAuthor();
////			System.out.println("Author: " + author);
////		});
//		
//		// Only using @EntityGraph
////		bookCrudRepo.getAllBooksOnlyUsingEntityGraph().forEach(book -> {
////			System.out.println("Book: " + book);
//////			Author author = book.getAuthor();
//////			System.out.println("Author: " + author);
////		});
//		
////		bookCrudRepo.getAllBooksUsingBatchSize().forEach(book -> {
////			System.out.println("Book: " + book);
////			Author author = book.getAuthor();
////			System.out.println("Author: " + author);
////		});
//		
//		// Using @BatchSize()
////		bookCrudRepo.findAll().forEach(book -> {
////			System.out.println("Book: " + book);
////			Author author = book.getAuthor();
////			System.out.println("Author: " + author);
////		});
//		
//		
////		Below still creates N+1
////		// using FetchType.EAGER in Author calls and Lazy in Book sides
////		bookCrudRepo.findAll().forEach(book -> {
////			System.out.println("Book: " + book);
////			Author author = book.getAuthor();
////			System.out.println("Author: " + author);
////		});
//		
//		//Using FetchMode.SUBSELECT
////		authorRepo.findAll().forEach( author -> {
////			System.out.println("Author: " + author);
////			author.getBooks().forEach( book -> {
////				System.out.println("Book: " + book);
////			});
////		});
//		
//		// Using Plain EAGER
////		authorRepo.findAll().forEach( author -> {
////			System.out.println("--------------- START -------------");
////			System.out.println("Author: " + author);
////			author.getBooks().forEach( book -> {
////				System.out.println("Book: " + book);
////			});
////			System.out.println("_______________ END ______________");
////		});
//
//	}
//
//	@EventListener(ApplicationReadyEvent.class)
//	public void run() {
//		System.out.println("Application running ...");
//
//		saveAuthorAndBook();
////		getAllAuthorDetails();
////		getAllBooksDetails();
//
//		System.out.println("DB Operations Completed ...");
//	}
//}
