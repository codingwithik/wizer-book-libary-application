package com.example.booklibraryapplication.controllers;

import com.example.booklibraryapplication.dto.request.BookRequest;
import com.example.booklibraryapplication.model.Book;
import com.example.booklibraryapplication.services.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
public class BookController {

    private  final BookService bookService;

    @PostMapping("/v1/book")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookRequest request) {
        return new ResponseEntity<>(bookService.addBook(request), HttpStatus.CREATED);
    }

    @GetMapping("/v1/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @GetMapping("/v1/books")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @PutMapping("/v1/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @Valid @RequestBody BookRequest request) {
        return new ResponseEntity<>(bookService.editBook(id, request), HttpStatus.OK);
    }

    @PostMapping("/v1/category/{categoryId}/book/{bookId}")
    public ResponseEntity<Book> addBookToCategory(@PathVariable long categoryId, @PathVariable long bookId) {
        return new ResponseEntity<>(bookService.addBookToCategory(categoryId, bookId), HttpStatus.OK);
    }
}
