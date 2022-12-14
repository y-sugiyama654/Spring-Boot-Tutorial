package com.spring.tutorial.presentation.entity.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Data
public class BookResponse {
    private String bookId;
    private String name;
    private LocalDateTime publishedDate;
}
