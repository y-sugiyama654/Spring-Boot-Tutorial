package com.spring.tutorial.presentation.entity.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class BookRequest {
    private String bookId;
    private String name;
    private LocalDateTime publishedDate;
}
