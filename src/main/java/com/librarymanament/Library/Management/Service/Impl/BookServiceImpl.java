package com.librarymanament.Library.Management.Service.Impl;

import com.librarymanament.Library.Management.Entity.Book;
import com.librarymanament.Library.Management.Repository.BookRepository;
import com.librarymanament.Library.Management.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).orElse(null);
        if (existingBook == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        existingBook.setTitle(book.getTitle());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setIsLoaned(book.getIsLoaned());

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteById(String id) {
        deleteById(id);
    }

    @Override
    public List<Book> findAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }
}
