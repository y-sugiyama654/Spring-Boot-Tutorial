package com.spring.tutorial.presentation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tutorial.domain.model.Book;
import com.spring.tutorial.domain.service.BookService;
import com.spring.tutorial.presentation.entity.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
