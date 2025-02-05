package com.digitalnation.library.model;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {

    private final List<BookDto> books = new ArrayList<>();

    public BookResponse() {
    }

    public BookResponse(List<BookDto> books) {
        this.books.addAll(books);
    }
    public List<BookDto> getBook() {
        return books;
    }
}
