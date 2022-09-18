package com.example.bookkeepingsys.controller;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.Book;
import com.example.bookkeepingsys.pojo.BookPojo;
import com.example.bookkeepingsys.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book/")
public class BookController extends ApiResponse {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("getAllBook")
    public ApiResponse getAllBooks()
    {
        return bookService.getAllBooks();
    }
    @PutMapping("addBook")
    public ApiResponse addBook(@RequestBody BookPojo  bookPojo)
    {
        return bookService.addBook(bookPojo);
    }

    @PostMapping("{bookId}/author/{authorId}")
    public ApiResponse bookToAuthor(@PathVariable Integer bookId,@PathVariable Integer authorId)
    {
        return bookService.bookToAuthor(bookId,authorId);
    }
}
