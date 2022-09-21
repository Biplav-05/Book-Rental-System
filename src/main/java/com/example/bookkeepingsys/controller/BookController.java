package com.example.bookkeepingsys.controller;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.Book;
import com.example.bookkeepingsys.pojo.BookPojo;
import com.example.bookkeepingsys.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("getAllBookWhithoutJoin")
    public ApiResponse getAllBookWhithoutJoin()
    {
        return bookService.getAllBookWhithoutJoin();
    }
    @PutMapping("addBook")
    public ApiResponse addBook(@RequestBody @Valid BookPojo  bookPojo)
    {
        return bookService.addBook(bookPojo);
    }


    //Add Autor to book
    @PostMapping("{bookId}/author/{authorId}")
    public ApiResponse bookToAuthor(@PathVariable Integer bookId,@PathVariable Integer authorId)
    {
        return bookService.bookToAuthor(bookId,authorId);
    }

    //Add category to book
    @PostMapping("{bookId}/category/{categoryId}")
    public ApiResponse addCategoryToBook(@PathVariable Integer bookId,@PathVariable Integer categoryId)
    {
        return bookService.addCategoryToBook(bookId,categoryId);
    }
    @GetMapping("find-book-only")
    public ApiResponse findBookOnly()
    {
        return bookService.findBookOnly();
    }

}
