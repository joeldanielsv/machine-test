package com.example.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Models.Author;
import com.example.test.Models.Book;
import com.example.test.Services.AuthorsService;

@CrossOrigin(maxAge = 3600)
@RestController
public class AuthorsController {

	@Autowired
	private AuthorsService authorsService;
		
	@GetMapping("/authors")
	public List<Author> getAuthors() {
		return authorsService.getAuthors();
	}	
	
	@GetMapping(path = "/authors", params = "id")
	public Author getAuthor(@RequestParam("id") Integer id) {
		return authorsService.getAuthor(id);
	}
	
	@PostMapping(path = "/author")
	public void addAuthor(@RequestBody Author author) {
		authorsService.addAuthor(author);
	}
	
	@DeleteMapping(path = "/author")
	public void deleteAuthor(@RequestParam("id") Integer id) {
		authorsService.deleteAuthor(id);
	}
	
	@PutMapping(path = "/author")
	public String updateAuthorDetails(@RequestBody Author author) {
		return authorsService.updateAuthorDetails(author);
	}
}
