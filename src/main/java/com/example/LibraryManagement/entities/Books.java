package com.example.LibraryManagement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Book_id")
    private int bookId;
    @Column(name="Book_Name")
    private String bookName;
    @Column(name = "Publisher")
    private String publisher;
    @Column(name = "description")
    private String description;
    @Column(name = "Publication")
    private String publication;
    @Column(name = "Publish_Year")
    private Integer publishYear;
    @Column(name = "Pages_count")
    private Integer pagesCount;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "Book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "Author_id"))
    private List<Authors> authors;

    public Books() {
    }

    public Books(String bookName, String publisher, String description, String publication, Integer publishYear, Integer pagesCount) {
        this.bookName = bookName;
        this.publisher = publisher;
        this.description = description;
        this.publication = publication;
        this.publishYear = publishYear;
        this.pagesCount = pagesCount;
        this.authors = new ArrayList<>();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", publication='" + publication + '\'' +
                ", publishYear=" + publishYear +
                ", pagesCount=" + pagesCount +
                ", authors=" + authors +
                '}';
    }
}


