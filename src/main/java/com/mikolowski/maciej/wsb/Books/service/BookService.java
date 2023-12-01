package com.mikolowski.maciej.wsb.Books.service;

import com.mikolowski.maciej.wsb.Books.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    public ResponseEntity<List<Book>> findAll() {
        List<Book> body = List.of();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(body, status);
    }

    public ResponseEntity<Book> findById(Integer id) {
        Book body = new Book();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(body, status);
    }

    public ResponseEntity<Book> addBook(Book book) {
        Book body = book;
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(body, status);
    }

    public ResponseEntity<Book> update(Book book) {
        Book body = book;
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(body, status);
    }

    public ResponseEntity<Book> delete(Integer id) {
        Book body = new Book();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(body, status);
    }
}
