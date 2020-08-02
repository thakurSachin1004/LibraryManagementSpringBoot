package com.example.LibraryManagement.services;

import com.example.LibraryManagement.entities.Authors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    void addAuthors(List<Authors> authors);
}
