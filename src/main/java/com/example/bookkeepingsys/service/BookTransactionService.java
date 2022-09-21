package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.pojo.BookTransactionPojo;
import org.springframework.stereotype.Service;

@Service
public interface BookTransactionService {


   ApiResponse addNewTransaction(BookTransactionPojo bookTransactionPojo);

    ApiResponse getAllDetails();

    ApiResponse findTodayTransaction();

    ApiResponse returnBook(BookTransactionPojo bookTransactionPojo);
}
