package com.digitalnation.library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "authors")
    private String authors;

    @Column(name = "title")
    private String title;

    @Column(name = "types")
    private String types;

    @Column(name = "year")
    private int year;

    @Column(name = "description")
    private String description;

    public Book() {
    }

    public Book(String isbn, String authors, String title, String types, int year, String description) {
        this.isbn = isbn;
        this.authors = authors;
        this.title = title;
        this.types = types;
        this.year = year;
        this.description = description;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}