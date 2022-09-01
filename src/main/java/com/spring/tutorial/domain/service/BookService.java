package com.spring.tutorial.domain.service;

import com.spring.tutorial.domain.model.Book;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookService {
    private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();

    public Book find(String bookId) {
        Book book = bookRepository.get(bookId);
        return book;
    }

    public Book create(Book book) {
        String bookId = UUID.randomUUID().toString();
        book.setBookId(bookId);
        bookRepository.put(bookId, book);
        return book;
    }

    public Book update(Book book) {
        return bookRepository.put(book.getBookId(), book);
    }

    @PostConstruct
    public void dummyData() {
        Book book = new Book();
        book.setBookId("000-0000-0001");
        book.setName("書籍名サンプル");
        book.setPublishedDate(LocalDateTime.of(2022, 8, 30, 12, 12, 10));
        bookRepository.put(book.getBookId(), book);
    }
}
