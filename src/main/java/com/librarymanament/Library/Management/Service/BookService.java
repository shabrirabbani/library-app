package com.librarymanament.Library.Management.Service;

import com.librarymanament.Library.Management.Entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book create(Book book);
    Book getBookById(String id);
    List<Book> getAll();
    Book update (Book book);
    void deleteById(String id);
    List<Book> findAvailableBooks();
}
