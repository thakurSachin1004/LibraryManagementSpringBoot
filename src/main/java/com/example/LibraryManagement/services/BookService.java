package com.example.LibraryManagement.services;

import com.example.LibraryManagement.entities.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Page<Books> getAllBooks(Integer pageNumber, Integer pageSize, String sortBy);
    Books getBookById(int bookId);
    void addBook(Books book);
    List<Books> getBooksByAuthorName(String authorName);
}
