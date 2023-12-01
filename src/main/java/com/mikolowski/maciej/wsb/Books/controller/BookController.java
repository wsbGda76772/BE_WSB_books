package com.mikolowski.maciej.wsb.Books.controller;

import com.mikolowski.maciej.wsb.Books.dto.Book;
import com.mikolowski.maciej.wsb.Books.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/books")
@Tag(name = "Books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    @Operation(summary = "Gets all books")
    public ResponseEntity<List<Book>> getList() {
        try {
            return bookService.findAll();
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gets specific book by id")
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id) {
        try {
            return bookService.findById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    @Operation(summary = "Adds new book")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        try {
            return bookService.addBook(book);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes book by id")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
        try {
            return bookService.delete(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    @Operation(summary = "Updates book by id")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book) {
        try {
            return bookService.update(book);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }
    }
}
