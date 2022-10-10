package com.example.booklibraryapplication.repositories;

import com.example.booklibraryapplication.model.Book;
import com.example.booklibraryapplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategory(Category category);

    Book findByCategory(Category category);
}
