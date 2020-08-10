package com.example.test.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.Dao.AuthorsRepository;
import com.example.test.Dao.BooksRepository;
import com.example.test.Models.Author;
import com.example.test.Models.Book;

@Service
public class BooksService {
	
	@Autowired
	private BooksRepository booksRepo;
	
	@Autowired
	private AuthorsRepository authorRepo;
	
	/**
	 * Loads books data into database. This is only for testing purpose.
	 */
	public void loadData() {
		Book b1 = new Book();
		b1.setBookId(1);
		b1.setBookName("Half Girlfriend");
		b1.setBookPrice("$5");
		b1.setCreateDate("29/04/2020");
		b1.setPublishedDate("1/05/2020");
		
		Author a1= new Author();
		a1.setAuthorId(1);
		a1.setAuthorName("Joel");
		
		Author a2= new Author();
		a2.setAuthorId(2);
		a2.setAuthorName("Daniel");
		
		b1.getAuthors().add(a1);
		b1.getAuthors().add(a2);
		
		a1.getBook().add(b1);
		a2.getBook().add(b1);
		
		booksRepo.save(b1);
		authorRepo.save(a1);
		authorRepo.save(a2);
	}

	/**
	 * Geturns the list of books
	 * 
	 * @return List of books.
	 */
	public List<Book> getBooks() {		
		List<Book> books = new ArrayList<>();
		books = booksRepo.findAll();
		return books;
	}
	
	/**
	 * Gets the book for the specific book id.
	 * 
	 * @param id Book ID.
	 * @return Book object.
	 */
	public Book getBook(Integer id) {
		Book book = new Book();
		book = booksRepo.findById(id).orElse(null);
		return book;
	}
	
	/**
	 * Adds the book.
	 * 
	 * @param book Book object.
	 */
	public void addBook(Book book) {
		booksRepo.save(book);
	}
	
	/**
	 * Deletes specific book with given id.
	 * 
	 * @param id Book ID to delete.
	 */
	public void deleteBook(Integer id) {
		booksRepo.deleteById(id);
	}
	
	/**
	 * Gets the author details for the book.
	 * 
	 * @param bookId Book ID.
	 * @return List of authors.
	 */
	public List<String> getAuthorDetails(Integer bookId) {
		List<String> authorsName = new ArrayList<>();
		List <Author> authors = authorRepo.getAuthorDetails(bookId);
		for(Author author: authors) {
			authorsName.add(author.getAuthorName());
		}
		return authorsName;
	}
	
	/**
	 * Updates book details.
	 * 
	 * @param book Book object to be updated.
	 * @return Saved object.
	 */
	public Book updateBookDetails(Book book) {
		Book existingBook = booksRepo.findById(book.getBookId()).orElse(null);
		existingBook.setBookPrice(book.getBookPrice());
		existingBook.setCreateDate(book.getCreateDate());
		existingBook.setPublishedDate(book.getPublishedDate());
		booksRepo.save(existingBook);
		return booksRepo.save(existingBook);
	}

}
