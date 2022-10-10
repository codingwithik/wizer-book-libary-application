package com.example.booklibraryapplication.repositories;

import com.example.booklibraryapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
