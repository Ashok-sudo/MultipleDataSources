package com.xtglobal.datasource.book.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtglobal.datasource.model.book.Book;
import com.xtglobal.datasource.repository.book.BookRepository;

@RestController
public class BookController 
{
	@Autowired
	private BookRepository bookRepository;
	
	@PostConstruct
	public void addData2DB()
	{
		bookRepository.saveAll(Stream.of(new Book(111,"Java"),new Book(222,"Spring Boot")).collect(Collectors.toList()));
		
	}
	

	@GetMapping("/getBooks")
	public List<Book> getBooks()
	{
		return bookRepository.findAll();
	}
	
	
	
}
