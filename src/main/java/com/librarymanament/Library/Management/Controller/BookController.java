package com.librarymanament.Library.Management.Controller;

import com.librarymanament.Library.Management.Entity.Book;
import com.librarymanament.Library.Management.Service.BookService;
import com.librarymanament.Library.Management.Service.UserService;
import com.librarymanament.Library.Management.constant.APIUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.BOOK)
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.create(book);
    }

    @GetMapping (path = APIUrl.PATH_VAR_ID)
    public Book getById(@PathVariable String id){
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @PutMapping
    public Book updateBook(
            @RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping(path = APIUrl.PATH_VAR_ID)
    public void delete(@PathVariable String id){
        bookService.deleteById(id);
    }
}
