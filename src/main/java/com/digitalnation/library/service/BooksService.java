package com.digitalnation.library.service;

import com.digitalnation.library.entities.Book;
import com.digitalnation.library.repositori.BooksRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class BooksService {

    private final BooksRepository booksRepository;

    public void addBook(Book newBook) {
        booksRepository.save(newBook);
    }

    public Book getBookbyId(Long id) throws NoSuchElementException {
        return booksRepository.findById(id).orElseThrow();
    }

    public List<Book> getAllBooks() {
        log.info("getAllBooks");
        return booksRepository.findAll();
    }

    @Transactional
    public void deleteBookbyId(Long id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public Book updateBookById(Long id) {
        Book book = booksRepository.findById(id).orElseThrow();
        return booksRepository.save(book);
    }
}
