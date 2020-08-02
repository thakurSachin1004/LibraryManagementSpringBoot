package com.example.LibraryManagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Author_id")
    private int author_id;
    @Column(name = "Author_FirstName")
    private String firstName;
    @Column(name = "Author_LastName")
    private String lastName;
    @Column(name = "Author_Country")
    private String country;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "Author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "Book_id"))
    private List<Books> books;

    public Authors() {
    }

    public Authors(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.books = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + author_id +
                ", name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
