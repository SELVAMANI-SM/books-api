package com.books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="department")
	private String department;
	@Column(name="rs")
	private Integer rs;
	@Column(name="e_book_link")
	private String eBookLink;
	@Column(name="image_link")
	private String imageLink;
	
	

}