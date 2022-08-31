package com.spring.tutorial.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private String bookId;
    private String name;
    private LocalDateTime publishedDate;
}
