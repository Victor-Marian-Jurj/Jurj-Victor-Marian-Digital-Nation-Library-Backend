package com.digitalnation.library.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BookDto {

    private Long bookId;

    private String isbn;

    private String authors;

    private String title;

    private String types;

    private int year;

    private String description;

    public BookDto() {
    }






}
