package com.example.test.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.test.Models.Author;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {
	

@Query(
		  value = "select * from  demo.author where demo.author.author_id in (\r\n" + 
		  		"			select authors_author_id from demo.book\r\n" + 
		  		"			join demo.author_book on demo.author_book.book_book_id = :bookId\r\n" + 
		  		"			where  demo.book.book_id=:bookId)", 
		  nativeQuery = true)
public List<Author> getAuthorDetails(Integer bookId);

}