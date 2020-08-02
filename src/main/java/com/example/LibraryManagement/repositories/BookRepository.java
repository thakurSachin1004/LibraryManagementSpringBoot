package com.example.LibraryManagement.repositories;

import com.example.LibraryManagement.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {
    Books findById(int id);
}
