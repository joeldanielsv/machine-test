package com.example.test.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.Dao.AuthorsRepository;
import com.example.test.Models.Author;
import com.example.test.Models.Book;

@Service
public class AuthorsService {
	
	@Autowired
	private AuthorsRepository authorsRepo;
	
	/**
	 * Gets the list of authors.
	 * 
	 * @return Authors list.
	 */
	public List<Author> getAuthors() {
		List<Author> authors = new ArrayList<>();
		authors = authorsRepo.findAll();
		return authors;
	}
	
	/**
	 * Gets the specific author based on ID.
	 * 
	 * @param id Author ID.
	 * @return Author object.
	 */
	public Author getAuthor(Integer id) {
		Author author = new Author();
		author = authorsRepo.findById(id).orElse(null);
		return author;
	}
	
	/**
	 * Adds author.
	 * 
	 * @param author Author object.
	 */
	public void addAuthor(Author author) {
		authorsRepo.save(author);
	}
	
	/**
	 * Deletes author object.
	 * 
	 * @param id author ID.
	 */
	public void deleteAuthor(Integer id) {
		authorsRepo.deleteById(id);
	}
	
	/**
	 * Updates author's details.
	 * 
	 * @param author Author object.
	 * @return Author object.
	 */
	public String updateAuthorDetails(Author author) {
		Author existingAuthor = authorsRepo.findById(author.getAuthorId()).orElse(null);
		existingAuthor.setAuthorName(author.getAuthorName());
		existingAuthor.setBook(author.getBook());
		authorsRepo.save(existingAuthor);
		return "Author updated successfully";
	}

	
}
