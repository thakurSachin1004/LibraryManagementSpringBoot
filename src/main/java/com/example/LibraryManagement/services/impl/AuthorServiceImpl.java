package com.example.LibraryManagement.services.impl;

import com.example.LibraryManagement.entities.Authors;
import com.example.LibraryManagement.repositories.AuthorRepository;
import com.example.LibraryManagement.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void addAuthors(List<Authors> authors) {
        authorRepository.saveAll(authors);
    }
}
