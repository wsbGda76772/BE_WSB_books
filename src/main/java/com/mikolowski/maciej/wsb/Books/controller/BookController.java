package com.mikolowski.maciej.wsb.Books.controller;

import com.mikolowski.maciej.wsb.Books.dto.Book;
import com.mikolowski.maciej.wsb.Books.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ok - returns list of books", content =
            { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "500", description = "Internal server error - returns empty book object", content =
            { @Content(mediaType = "application/json") })}
    )
    public ResponseEntity<List<Book>> getList() {
        try {
            return bookService.findAll();
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gets specific book by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ok - returns requested book object", content =
            { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "Not found - returns empty book object", content =
            { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "500", description = "Internal server error - returns empty book object", content =
            { @Content(mediaType = "application/json") })}
    )
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id) {
        try {
            return bookService.findById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    @Operation(summary = "Adds new book")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ok - returns added book object", content =
            { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "'401", description = "Unauthorized - you don't have access to this operation"),
        @ApiResponse(responseCode = "500", description = "Internal server error - returns empty book object", content =
            { @Content(mediaType = "application/json") })}
    )
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        try {
            return bookService.addBook(book);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes book by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ok - returns deleted book object", content =
            { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "204", description = "No content - returns empty book object", content =
            { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "'401", description = "Unauthorized - you don't have access to this operation"),
        @ApiResponse(responseCode = "500", description = "Internal server error - returns empty book object", content =
            { @Content(mediaType = "application/json") })}
    )
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
        try {
            return bookService.delete(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    @Operation(summary = "Updates book by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ok - returns updated book object", content =
            { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "204", description = "No content - returns empty book object", content =
            { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "'401", description = "Unauthorized - you don't have access to this operation"),
        @ApiResponse(responseCode = "500", description = "Internal server error - returns empty book object", content =
            { @Content(mediaType = "application/json") })}
    )
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book) {
        try {
            return bookService.update(book);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }
    }
}
