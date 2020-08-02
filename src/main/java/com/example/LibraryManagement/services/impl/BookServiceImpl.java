package com.example.LibraryManagement.services.impl;

import com.example.LibraryManagement.entities.Authors;
import com.example.LibraryManagement.entities.Books;
import com.example.LibraryManagement.repositories.AuthorRepository;
import com.example.LibraryManagement.repositories.BookRepository;
import com.example.LibraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Books> getAllBooks(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Page<Books> pagedResult = bookRepository.findAll(pageable);
        if(pagedResult.hasContent())
            return pagedResult.getContent();
        else
            return new ArrayList<Books>();
    }

    @Override
    public Books getBookById(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public void addBook(Books book) {
        List<Authors> authors = new ArrayList<>();
        authorRepository.saveAll(authors);
        bookRepository.save(book);
    }

    @Override
    public List<Books> getBooksByAuthorName(String authorName) {
        return null;
    }
}
