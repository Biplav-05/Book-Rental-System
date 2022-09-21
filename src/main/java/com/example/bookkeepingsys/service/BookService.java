package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.pojo.BookPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    ApiResponse getAllBooks();


    ApiResponse addBook(BookPojo bookPojo);

    ApiResponse bookToAuthor(Integer bookId, Integer authorId);

    ApiResponse addCategoryToBook(Integer bookId, Integer categoryId);

    ApiResponse getAllBookWhithoutJoin();

    ApiResponse findBookOnly();
}
