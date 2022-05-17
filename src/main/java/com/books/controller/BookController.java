package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.dao.BookRepository;
import com.books.dto.Message;
import com.books.exception.ValidationException;
import com.books.model.Book;
import com.books.validation.BookValidation;




@RestController
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("book/addBook")
	public ResponseEntity<?> addBook(@RequestParam("name") String name, @RequestParam("department") String department,@RequestParam("rs") Integer rs,
			@RequestParam("eBookLink") String eBookLink,
			@RequestParam("imageLink") String imageLink) {

		Book book = new Book();

		book.setName(name);
		book.setDepartment(department);
		book.setRs(rs);
		book.setEBookLink(eBookLink);
		book.setImageLink(imageLink);

		try {
			BookValidation.bookCheck(book);
			bookRepository.save(book);
			Message message = new Message("success");
			return new ResponseEntity<>(message, HttpStatus.OK);

		} catch (ValidationException e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {
			e.printStackTrace();
			Message message = new Message("server");
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);

		}

}
	@GetMapping("book/display")
	public ResponseEntity<?> bookDisplay() {
		List<Book> bookList = null;
		try {
			bookList = bookRepository.findAll();
			return new ResponseEntity<>(bookList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Message message = new Message("server error");
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("book/findByName/{name}")
	public ResponseEntity<?> findByName(@PathVariable("name") String name) {
		List<Book> bookList = null;
		try {
			bookList = BookRepository.bookName(name);
			return new ResponseEntity<>(bookList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Message message = new Message("server error");
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("book/findByDepartment/{department}")
	public ResponseEntity<?> findByDepartment(@PathVariable("department") String department) {
		List<Book> bookList = null;
		try {
			bookList = bookRepository.findByDepartment(department);
			return new ResponseEntity<>(bookList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Message message = new Message("server error");
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("book/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {

		try {
			bookRepository.deleteByBookId(id);
			Message message = new Message("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Message message = new Message("server error");
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}