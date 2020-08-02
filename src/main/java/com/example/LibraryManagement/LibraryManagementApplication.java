package com.example.LibraryManagement;

import com.example.LibraryManagement.entities.Authors;
import com.example.LibraryManagement.entities.Books;
import com.example.LibraryManagement.repositories.AuthorRepository;
import com.example.LibraryManagement.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;


	@Override
	public void run(String... args) throws Exception {

		Books book1 = new Books("Algorithm", "xyz", "tttt", "sdfg", 2019, 500);
		Books book2 = new Books("Data Structure", "xyz", "tttt", "sdfg", 2019, 500);
		bookRepository.save(book1);
		bookRepository.save(book2);

		Authors a1 = new Authors("a", "b", "India");
		Authors a2 = new Authors("x", "y", "Africa");
		authorRepository.saveAll(Arrays.asList(a1, a2));

		Authors b1 = new Authors("a1", "b1", "India");
		Authors b2 = new Authors("x1", "y1", "Africa");

		authorRepository.saveAll(Arrays.asList(b1, b2));

		book1.getAuthors().addAll(Arrays.asList(a1, a2));
		book2.getAuthors().addAll(Arrays.asList(b1, b2));


		bookRepository.save(book1);
		bookRepository.save(book2);
//
//		int id = 1;
//		List<Books> books = bookRepository.findAll();
//		System.out.println(books);
//		Books res1 = bookRepository.findById(id);
//		System.out.println(res1.getAuthors());
//
//		System.out.println(authorRepository.findById(id).getBooks());

		Authors sachin = new Authors("Sachin", "Thakur", "India");
//		Authors a2 = new Authors("x", "y", "Africa");
		authorRepository.save(sachin);

		Books sachinBook1 = new Books("Operating System", "xyz", "Os book", "sdfg", 2019, 500);
		Books sachinBook2 = new Books("Spring Boot", "xyz", "Spring boot book", "sdfg", 2019, 500);
		bookRepository.saveAll(Arrays.asList(sachinBook1, sachinBook2));

		sachin.getBooks().addAll(Arrays.asList(sachinBook1,sachinBook2));
		authorRepository.save(sachin);
	}
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

}


