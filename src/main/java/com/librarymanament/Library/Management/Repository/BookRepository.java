package com.librarymanament.Library.Management.Repository;

import com.librarymanament.Library.Management.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT b FROM Book b WHERE b.isLoaned = false")
    List<Book> findAvailableBooks();
}
