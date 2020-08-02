package com.example.LibraryManagement.repositories;

import com.example.LibraryManagement.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {
    Authors findById(int id);
}
