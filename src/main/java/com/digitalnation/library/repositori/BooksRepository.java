package com.digitalnation.library.repositori;

import com.digitalnation.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
