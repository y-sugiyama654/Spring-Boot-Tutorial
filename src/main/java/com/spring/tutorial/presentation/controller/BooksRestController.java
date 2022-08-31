package com.spring.tutorial.presentation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tutorial.domain.model.Book;
import com.spring.tutorial.domain.service.BookService;
import com.spring.tutorial.presentation.entity.request.BookRequest;
import com.spring.tutorial.presentation.entity.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BooksRestController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> getBook(@PathVariable String bookId) throws JsonProcessingException {
        Book book = bookService.find(bookId);

        BookResponse response = new BookResponse();
        response.setBookId(book.getBookId());
        response.setName(book.getName());
        response.setPublishedDate(book.getPublishedDate());

        return ResponseEntity.ok(response);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBook(@Validated @RequestBody BookRequest request) {
        Book newBook = new Book();

        newBook.setName(request.getName());
        newBook.setPublishedDate(request.getPublishedDate());

        Book createdBook = bookService.create(newBook);

        String resourceUri = "http://localhost:8080/books/" + createdBook.getBookId();

        return ResponseEntity.created(URI.create(resourceUri)).build();

    }
}
