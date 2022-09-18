package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.pojo.AuthorPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    ApiResponse totalAuthor();

    ApiResponse addAuthor(AuthorPojo authorPojo);
}
