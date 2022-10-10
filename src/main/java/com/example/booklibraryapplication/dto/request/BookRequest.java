package com.example.booklibraryapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
public @Data class BookRequest {

    @NotNull(message = "Book title is required")
    private String title;
    @NotNull(message = "Book author is required")
    private String author;
    private String description;
    @NotNull(message = "Book isbn is required")
    private String isbn;
    private String edition;

}
