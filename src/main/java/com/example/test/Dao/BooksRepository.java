package com.example.test.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.test.Models.Author;
import com.example.test.Models.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

}
