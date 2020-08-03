package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.entities.Books;
import com.example.LibraryManagement.services.AuthorService;
import com.example.LibraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @PostMapping
    public void addBook(@RequestBody Books book) {
        authorService.addAuthors(book.getAuthors());
        bookService.addBook(book);
    }

    @GetMapping
    public Page<Books> getBooks(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "bookId") String sortBy

    )
    {
        Page<Books> booksList = bookService.getAllBooks(pageNumber, pageSize, sortBy);
        return booksList;
    }

    @GetMapping("/{bookId}")
    public Books getBook(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }
}
