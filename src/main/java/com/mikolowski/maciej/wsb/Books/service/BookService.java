package com.mikolowski.maciej.wsb.Books.service;

import com.mikolowski.maciej.wsb.Books.dao.BookRepository;
import com.mikolowski.maciej.wsb.Books.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<List<Book>> findAll() {
        List<Book> body = bookRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(body, status);
    }

    public ResponseEntity<Book> findById(Integer id) {
        Book body = bookRepository.findById(id)
                .orElse(new Book());
        HttpStatus status = HttpStatus.OK;
        if (body.getId() == null) {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(body, status);
    }

    public ResponseEntity<Book> addBook(Book book) {
        Book body = bookRepository.save(book);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(body, status);
    }

    public ResponseEntity<Book> update(Book book) {
        HttpStatus status = HttpStatus.OK;
        Optional<Book> bookInDb = bookRepository.findById(book.getId());
        if (bookInDb.isPresent()) {
            Book body = bookRepository.save(book);
            return new ResponseEntity<>(body, status);
        } else {
            status = HttpStatus.NO_CONTENT;
            return new ResponseEntity<>(new Book(), status);
        }
    }

    public ResponseEntity<Book> delete(Integer id) {
        HttpStatus status = HttpStatus.OK;
        Optional<Book> bookInDb = bookRepository.findById(id);
        if (bookInDb.isPresent()) {
            bookRepository.delete(bookInDb.get());
            return new ResponseEntity<>(bookInDb.get(), status);
        } else {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, status);
        }
    }
}
