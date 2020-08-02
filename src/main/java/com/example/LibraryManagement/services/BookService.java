package com.example.LibraryManagement.services;

import com.example.LibraryManagement.entities.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Books> getAllBooks();
    Books getBookById(int bookId);
    void addBook(Books book);
    List<Books> getBooksByAuthorName(String authorName);
}
