package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.entities.Books;
import com.example.LibraryManagement.services.AuthorService;
import com.example.LibraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
    public CollectionModel<Books> getBooks(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "bookId") String sortBy
    )
    {
        List<Books> booksList = bookService.getAllBooks(pageNumber, pageSize, sortBy);
        Link link = linkTo(methodOn(BookController.class).getBooks(pageNumber, pageSize, sortBy)).withSelfRel();


        return new CollectionModel<>(booksList, link);
    }
}
