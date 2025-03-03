package com.digitalnation.library.controller;


import com.digitalnation.library.entities.Book;
import com.digitalnation.library.model.BookDto;
import com.digitalnation.library.model.BookResponse;
import com.digitalnation.library.model.CreateBookRequest;
import com.digitalnation.library.model.UpdateBookRequest;
import com.digitalnation.library.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BooksController {

    @Autowired
    private ModelMapper modelMapper;
    private final BooksService booksService;

    @PostMapping
    public void createBook(@RequestBody CreateBookRequest requestBody, Authentication authentication) {
        Book newBook = new Book();
        newBook.setIsbn(requestBody.getIsbn());
        newBook.setAuthors(requestBody.getAuthors());
        newBook.setTitle(requestBody.getTitle());
        newBook.setYear(requestBody.getYear());
        newBook.setTypes(requestBody.getTypes());
        newBook.setDescription(requestBody.getDescription());
        booksService.addBook(newBook);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> readBookById(@PathVariable Long id) {
        try {
            Book responseBody = booksService.getBookbyId(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    private BookDto convertToDTO(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    @GetMapping
    public ResponseEntity<BookResponse> readAllBooks(Authentication authentication) {
        List<Book> books = booksService.getAllBooks();
        List<BookDto> bookDtoList = books.stream().map(this::convertToDTO).collect(Collectors.toList());
        BookResponse responseBody = new BookResponse(bookDtoList);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id, Authentication authentication) {
        try {
            booksService.deleteBookbyId(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Book> updateBook(@RequestBody UpdateBookRequest requestBody, @PathVariable Long id, Authentication authentication) {
        try {
            Book responseBody = booksService.updateBookById(id);
            responseBody.setIsbn(requestBody.getIsbn());
            responseBody.setAuthors(requestBody.getAuthors());
            responseBody.setTitle(requestBody.getTitle());
            responseBody.setDescription(requestBody.getDescription());
            responseBody.setYear(requestBody.getYear());
            responseBody.setTypes(requestBody.getTypes());
            booksService.updateBookById(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
