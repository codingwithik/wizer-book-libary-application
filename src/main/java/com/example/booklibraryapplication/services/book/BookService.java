package com.example.booklibraryapplication.services.book;

import com.example.booklibraryapplication.dto.request.BookRequest;
import com.example.booklibraryapplication.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(BookRequest request);
    List<Book> getBooks();
    Book getBook(long id);
    Book editBook(long id, BookRequest request);
    Book addBookToCategory(long categoryId, long bookId);
}
