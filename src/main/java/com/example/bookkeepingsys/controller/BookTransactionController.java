package com.example.bookkeepingsys.controller;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.pojo.BookTransactionPojo;
import com.example.bookkeepingsys.service.BookTransactionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("book-transaction")
public class BookTransactionController extends ApiResponse {
    private final BookTransactionService bookTransactionService;

    public BookTransactionController(BookTransactionService bookTransactionService) {
        this.bookTransactionService = bookTransactionService;
    }

    @PostMapping("rent-book")
    public ApiResponse addTransaction(@RequestBody @Valid BookTransactionPojo bookTransactionPojo)
    {
        return bookTransactionService.addNewTransaction(bookTransactionPojo);
    }
    @GetMapping("view-all-transaction")
    public ApiResponse getAllTransaction()
    {
        return bookTransactionService.getAllDetails();
    }

    @GetMapping("get-today-tranasction")
    public ApiResponse getTodyTransaction()
    {
        return bookTransactionService.findTodayTransaction();
    }
    @PostMapping("return-book")
    public ApiResponse returnBook(@RequestBody BookTransactionPojo bookTransactionPojo)
    {
        return bookTransactionService.returnBook(bookTransactionPojo);
    }


}
