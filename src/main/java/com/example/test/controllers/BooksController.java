package com.example.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Models.Author;
import com.example.test.Models.Book;
import com.example.test.Services.AuthorsService;
import com.example.test.Services.BooksService;

@CrossOrigin(maxAge = 3600)
@RestController
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@GetMapping("/load")
	public void loadBooks() {
		booksService.loadData();
	}	
		
	@GetMapping("/books")
	public List<Book> getBooks() {
		return booksService.getBooks();
	}	
	
	@GetMapping(path = "/books", params = "id")
	public Book getBook(@RequestParam("id") Integer id) {
		return booksService.getBook(id);
	}
	
	@GetMapping(path = "/{bookId}/author")
	public List<String> getAuthorDetails(@PathVariable("bookId") Integer bookId) {
		return booksService.getAuthorDetails(bookId);
	}
	
	@PostMapping(path = "/book")
	public void addBook(@RequestBody Book book) {
		booksService.addBook(book);
	}
	
	@DeleteMapping(path = "/book")
	public void deleteBook(@RequestParam("id") Integer id) {
		booksService.deleteBook(id);
	}
	
	@PutMapping(path = "/book")
	public Book updateBookDetails(@RequestBody Book book) {
		return booksService.updateBookDetails(book);
	}

}
