package com.example.booklibraryapplication.services.book;

import com.example.booklibraryapplication.dto.request.BookRequest;
import com.example.booklibraryapplication.exception.NotFoundException;
import com.example.booklibraryapplication.model.Book;
import com.example.booklibraryapplication.model.Category;
import com.example.booklibraryapplication.repositories.BookRepository;
import com.example.booklibraryapplication.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Book addBook(BookRequest request) {

        Book newBook = new Book();
        newBook.setAuthor(request.getAuthor());
        newBook.setDescription(request.getDescription());
        newBook.setEdition(request.getEdition());
        newBook.setTitle(request.getTitle());
        newBook.setIsbn(request.getIsbn());
        newBook = bookRepository.save(newBook);

        return newBook;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found!"));
    }

    @Override
    public Book editBook(long id, BookRequest request) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found!"));

        book.setAuthor(request.getAuthor());
        book.setDescription(request.getDescription());
        book.setEdition(request.getEdition());
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        bookRepository.save(book);

        return book;
    }

    @Override
    public Book addBookToCategory(long categoryId, long bookId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new NotFoundException("Category with Id: "+categoryId+" not found"));

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found!"));

        category.getBooks().add(book);
        categoryRepository.save(category);

        return book;
    }


}
