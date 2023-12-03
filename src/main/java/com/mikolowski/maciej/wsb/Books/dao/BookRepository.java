package com.mikolowski.maciej.wsb.Books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mikolowski.maciej.wsb.Books.dto.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
