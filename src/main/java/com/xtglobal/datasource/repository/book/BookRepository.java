package com.xtglobal.datasource.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xtglobal.datasource.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
