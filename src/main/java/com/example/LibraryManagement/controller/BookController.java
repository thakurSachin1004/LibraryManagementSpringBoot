package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.entities.Books;
import com.example.LibraryManagement.services.AuthorService;
import com.example.LibraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @PostMapping("/addBook")
    public void addBook(@RequestBody Books book) {
        authorService.addAuthors(book.getAuthors());
        bookService.addBook(book);
    }
}
