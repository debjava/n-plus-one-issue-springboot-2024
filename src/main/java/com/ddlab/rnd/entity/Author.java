package com.ddlab.rnd.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Author")
@Table(name = "author")
@Getter
@Setter
@ToString(exclude = "books") //Otherwise, it will throw Stackoverflow error
public class Author {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

//	@BatchSize(size = 3)
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade = CascadeType.ALL)
//	@Fetch(FetchMode.SUBSELECT) // Hibernate Specific
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private Set<Book> books = new HashSet<>();
	
	public Author() {
		super();
	}

	public Author(String name) {
		super();
		this.name = name;
	}

}
