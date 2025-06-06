package com.ddlab.rnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Book")
@Table(name = "book")
@Getter
@Setter
@ToString
//@NamedEntityGraph(
//	    name = "Book.author",
//	    attributeNodes = @NamedAttributeNode("author")
//	)
public class Book {

	@Id
	@GeneratedValue
    private Long id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "price")
	private int price;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Author author;
	
	public Book() {
		super();
	}

	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


}
